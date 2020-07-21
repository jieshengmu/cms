package cn.itsource.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.itsource.domain.FeedBacks;
import cn.itsource.domain.Slide;
import cn.itsource.mapper.FeedBacksMapper;
import cn.itsource.query.FeedBacksQuery;
import cn.itsource.service.IFeedBacksService;
import cn.itsource.util.PageBean;

/**
 * @Title: FeedBacks.java
 * @author:牟胜杰
 * @Package:cn.itsource.service.impl
 * @Description:(作用:好评如潮实现层)
 * @date:2020年7月17日 下午2:19:34
 * @version:V1.0  
 */
@Service//创建对象
public class FeedBacksServiceImpl implements IFeedBacksService {

	@Autowired//依赖注入，给字段赋值
	private FeedBacksMapper mapper;

	@Override
	public PageBean<FeedBacks> findAll(FeedBacksQuery query) {
		//根据查询条件查询总条数
		Integer totals = mapper.findCount(query);
		//如果总条数为0，没有数据
		if (totals == 0) {
			return new PageBean<FeedBacks>();//0和空集合
		}

		//接收查询到的数据
		List<FeedBacks> feedbacks = mapper.findAll(query);

		//返回有数据的PageBean
		return new PageBean<>(totals, feedbacks);
	}

	/**
	 * @Description:(作用:根据id进行删除)
	 * @param:@param id
	 * @param:@param req   
	 * @author:牟胜杰
	 * @date:2020年7月17日下午3:00:18
	 * @version:V1.0
	 */
	@Override
	public void del(Long id, HttpServletRequest req) {

		//根据id查询对象
		FeedBacks fBacks = mapper.findById(id);
		//删除数据库对象
		mapper.del(id);
		//获取到图片路径
		String templatePath = req.getServletContext().getRealPath("/hpupload");
		//创建文件对象,获取slide对象的name
		File file = new File(templatePath,fBacks.getName());
		//判断静态资源文件是否存在
		if (file.exists()) {
			//存在则进行删除
			file.delete();
		}


	}

	@Override
	public void save(FeedBacks fBacks, MultipartFile photo, HttpServletRequest req) throws IOException {
		String parentPath = null;
		//判断是否上传文件
		if (photo != null) {
			//1、输入流
			InputStream in = photo.getInputStream();

			//使用相对路径获取文件的绝对路径(父路径)
			parentPath = req.getServletContext().getRealPath("/hpupload");
			//创建文件对象，用于判断文件是否存在
			File file = new File(parentPath);
			if (!file.exists()) {//如果文件不存在
				file.mkdir();//就创建
			}
			//获取图片的原始文件名
			String oName = photo.getOriginalFilename();
			//获取文件名后缀
			String suffix = oName.substring(oName.lastIndexOf("."));//saddsa.jpg
			//拼接时间戳后的文件名
			String name = System.currentTimeMillis() + suffix;
			//2、输出流
			FileOutputStream out = new FileOutputStream(new File(parentPath, name));

			//3、复制IOUtils.copy(in, out);
			IOUtils.copy(in, out);

			//关流
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
			//复制之后，将文件名和路径设置回去
			fBacks.setName(name);
			fBacks.setPath("/hpupload/" + name );
		}

		if (fBacks.getId() == null) {//添加
			if (photo != null) {//并且photo不等于null
				mapper.add(fBacks);//添加
			}
		}else {//修改
			
			System.out.println("fBacks" + fBacks);
			//根据id进行查询，返回一个数据库对象
			FeedBacks dbFBacks = mapper.findById(fBacks.getId());
			//进行修改操作
			mapper.update(fBacks);
			//判断是否重新上传了图片，重新上传，我们就删除，没有就不管
			if (photo != null) {
				//创建文件对象
				File file = new File(parentPath, dbFBacks.getName());
				//判断服务器上面文件是否存在
				if (file.exists()) {
					//存在就删除
					file.delete();
				}
			}
		}
		
	}

	/**
	 * @Description:(作用:响应到前台，好评如潮)
	 * @param:@return   
	 * @author:牟胜杰
	 * @date:2020年7月17日下午3:46:10
	 * @version:V1.0
	 */
	@Override
	public List<FeedBacks> getFeeds() {
		return mapper.getFeeds();
	}

}
