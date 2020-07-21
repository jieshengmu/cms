package cn.itsource.service.impl;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itsource.domain.FAQ;
import cn.itsource.domain.Slide;
import cn.itsource.mapper.FaqMapper;
import cn.itsource.query.FaqQuery;
import cn.itsource.service.IFaqService;
import cn.itsource.util.PageBean;

/**
 * @Title: FaqServiceImpl.java
 * @author:牟胜杰
 * @Package:IFaqService
 * @Description:(作用:常见问题service实现层)
 * @date:2020年7月17日 上午9:59:41
 * @version:V1.0  
 */
@Service//创建对象
public class FaqServiceImpl implements IFaqService {
	@Autowired//给字段赋值
	private FaqMapper mapper;

	/**
	 * @Description:(作用:查询数据显示到后台列表)
	 * @param:@param query
	 * @param:@return   
	 * @author:牟胜杰
	 * @date:2020年7月17日上午10:00:57
	 * @version:V1.0
	 */
	@Override
	public PageBean<FAQ> findAll(FaqQuery query) {
		//根据查询条件查询总条数
		Integer totals = mapper.findCount(query);
		//如果总条数为0，没有数据
		if (totals == 0) {
			return new PageBean<FAQ>();//0和空集合
		}

		//接收查询到的数据
		List<FAQ> faqs = mapper.findAll(query);

		//返回有数据的PageBean
		return new PageBean<>(totals, faqs);
	}

	/**
	 * @Description:(作用:根据id进行删除)
	 * @param:@param id   
	 * @author:牟胜杰
	 * @date:2020年7月17日上午10:39:57
	 * @version:V1.0
	 */
	@Override
	public void del(Long id) {
		//删除数据库对象
		mapper.del(id);
	}

	/**
	 * @Description:(作用:保存和修改，常见问题)
	 * @param:@param faq   
	 * @author:牟胜杰
	 * @date:2020年7月17日上午11:18:51
	 * @version:V1.0
	 */
	@Override
	public void save(FAQ faq) {
		//判断传入的id是否为null
		if (faq.getId() == null) {//添加
			mapper.add(faq);//添加
		}else{//修改
			//进行修改操作
			mapper.update(faq);
		}

	}

	/**
	 * @Description:(作用:获取所有常见问题)
	 * @param:@return   
	 * @author:牟胜杰
	 * @date:2020年7月17日上午11:54:02
	 * @version:V1.0
	 */
	@Override
	public List<FAQ> getFaqs() {
		
		return mapper.faqs();
	}





}
