package cn.itsource.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.itsource.domain.Article;
import cn.itsource.query.ArticleQuery;
import cn.itsource.util.PageBean;

/**
* @author 作者 E-mail:牟胜杰
* @version 创建时间：2020年7月9日 上午10:36:07
* 
*/
public interface IArticleService {

	/**
	 * @Description:(作用:查询所有文章列表)
	 * @param:@return   
	 * @return:List<Article>  
	 * @author:牟胜杰
	 * @date:2020年7月9日上午11:44:17
	 * @version:V1.0
	 * @param query 
	 */
	PageBean<Article> findAll(ArticleQuery query);

	/**
	 * @Description:(作用:传入id调用方法进行删除)
	 * @param:@param id   
	 * @return:void  
	 * @author:牟胜杰
	 * @date:2020年7月10日下午1:18:48
	 * @version:V1.0
	 * @param req 
	 */
	void del(Long id, HttpServletRequest req);

	/**
	 * @Description:(作用:添加和修改)
	 * @param:@param article   
	 * @return:void  
	 * @author:牟胜杰
	 * @date:2020年7月10日下午4:52:39
	 * @version:V1.0
	 * @param req 
	 */
	void save(Article article, HttpServletRequest req);

	/**
	 * @Description:(作用:查询文章)
	 * @param:@return   
	 * @return:Map<String,Object>  
	 * @author:牟胜杰
	 * @date:2020年7月12日上午11:07:50
	 * @version:V1.0
	 */
	Map<String, Object> getArticles();

	/**
	 * @Description:(作用:根据url查询文章添加点击次数)
	 * @param:@param url
	 * @param:@return   
	 * @return:Article  
	 * @author:牟胜杰
	 * @date:2020年7月13日上午10:06:09
	 * @version:V1.0
	 */
	Article updateClickCount(String url);
	

}
