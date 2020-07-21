package cn.itsource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itsource.domain.Article;
import cn.itsource.domain.ArticleType;
import cn.itsource.mapper.ArticleMapper;
import cn.itsource.mapper.ArticleTypeMapper;
import cn.itsource.query.ArticleQuery;
import cn.itsource.service.IArticleTypeService;
import cn.itsource.util.PageBean;

/**
 * @Title: ArticleTypeServiceImpl.java
 * @Package:cn.itsource.service.impl
 * @Description:(作用:查询所有文章类型)
 * @author:牟胜杰
 * @date:2020年7月10日 上午9:41:22
 * @version:V1.0  
 */
@Service//创建对象
public class ArticleTypeServiceImpl implements IArticleTypeService {
	@Autowired//依赖注入，会根据当前字段类型查找，给当前字段赋值
	private ArticleTypeMapper typeMapper;

	/**
	 * @Description:(作用:查询所有文章类型)
	 * @param:@return   
	 * @author:牟胜杰
	 * @date:2020年7月10日上午9:41:40
	 * @version:V1.0
	 */
	@Override
	public List<ArticleType> findTypeAll() {
		//返回查询所有文章类型
		return typeMapper.findTypeAll();
	}
	
	

		
}
