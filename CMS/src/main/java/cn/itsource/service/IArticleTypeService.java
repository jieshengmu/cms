package cn.itsource.service;

import java.util.List;

import cn.itsource.domain.ArticleType;

/**
 * @Title: IArticleTypeService.java
 * @Package:cn.itsource.service
 * @Description:(作用:查询所有文章类型)
 * @author:牟胜杰
 * @date:2020年7月10日 上午9:39:58
 * @version:V1.0  
 */
public interface IArticleTypeService {

	/**
	 * @Description:(作用:查询所有文章类型)
	 * @param:@return   
	 * @return:List<ArticleType>  
	 * @author:牟胜杰
	 * @date:2020年7月10日上午9:28:18
	 * @version:V1.0
	 */
	List<ArticleType> findTypeAll();
	

}
