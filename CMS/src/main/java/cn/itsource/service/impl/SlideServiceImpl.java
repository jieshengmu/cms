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

import cn.itsource.domain.FAQ;
import cn.itsource.domain.Slide;
import cn.itsource.mapper.SlideMapper;
import cn.itsource.query.SlideQuery;
import cn.itsource.service.ISlideService;
import cn.itsource.util.PageBean;

/**
 * @Title: SlideServiceImpl.java
 * @author:牟胜杰
 * @Package:ISlideService
 * @Description:(作用SlideServiceImpl实现层)
 * @date:2020年7月13日 下午2:18:13
 * @version:V1.0  
 */
@Service//创建对象
public class SlideServiceImpl implements ISlideService {
	@Autowired //依赖注入，给字段赋值
	private SlideMapper mapper;

	/**
	 * @Description:(作用:根据条件查询)
	 * @param:@param query
	 * @param:@return   
	 * @author:牟胜杰
	 * @date:2020年7月13日下午2:31:48
	 * @version:V1.0
	 */
	@Override
	public PageBean<Slide> findAll(SlideQuery query) {
		//根据查询条件查询总条数
		Integer totals = mapper.findCount(query);
		//如果总条数为0，没有数据
		if (totals == 0) {
			return new PageBean<Slide>();//0和空集合
		}

		//接收查询到的数据
		List<Slide> Slides = mapper.findAll(query);

		//返回有数据的PageBean
		return new PageBean<>(totals, Slides);
	}

	/**
	 * @Description:(作用:文件上传)
	 * @param:@param slide
	 * @param:@param photo
	 * @param:@param req   
	 * @author:牟胜杰
	 * @date:2020年7月13日下午4:20:36
	 * @version:V1.0
	 * @throws IOException 
	 */
	@Override
	public void save(Slide slide, MultipartFile photo, HttpServletRequest req) throws IOException {
		String parentPath = null;
		//判断是否上传文件
		if (photo != null) {
			//1、输入流
			InputStream in = photo.getInputStream();

			//使用相对路径获取文件的绝对路径(父路径)
			parentPath = req.getServletContext().getRealPath("/upload");
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
			slide.setName(name);
			slide.setPath("/upload/" + name );
		}

		if (slide.getId() == null) {//添加
			if (photo != null) {//并且photo不等于null
				mapper.add(slide);//添加
			}
		}else {//修改
			//根据id进行查询，返回一个数据库对象
			Slide dbSlide = mapper.findById(slide.getId());
			//进行修改操作
			mapper.update(slide);
			//判断是否重新上传了图片，重新上传，我们就删除，没有就不管
			if (photo != null) {
				//创建文件对象
				File file = new File(parentPath, dbSlide.getName());
				//判断服务器上面文件是否存在
				if (file.exists()) {
					//存在就删除
					file.delete();
				}
			}
		}
	}

	/**
	 * @Description:(作用:根据id进行删除)
	 * @param:@param id
	 * @param:@param req   
	 * @author:牟胜杰
	 * @date:2020年7月13日下午5:54:25
	 * @version:V1.0
	 */
	@Override
	public void del(Long id, HttpServletRequest req) {

		//根据id查询对象
		Slide slide = mapper.findById(id);
		//删除数据库对象
		mapper.del(id);
		//获取到图片路径
		String templatePath = req.getServletContext().getRealPath("/upload");
		//创建文件对象,获取slide对象的name
		File file = new File(templatePath,slide.getName());
		//判断静态资源文件是否存在
		if (file.exists()) {
			//存在则进行删除
			file.delete();
		}

	}

	/**
	 * @Description:(作用:查询所有轮播图)
	 * @param:@return   
	 * @author:牟胜杰
	 * @date:2020年7月15日上午10:51:00
	 * @version:V1.0
	 */
	@Override
	public List<Slide> getSlides() {
		
		return mapper.getSlides();
	}
}
