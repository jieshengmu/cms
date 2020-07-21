package cn.itsource.mapper;

import java.util.List;

import cn.itsource.domain.Article;
import cn.itsource.domain.ArticleType;
import cn.itsource.query.ArticleQuery;

/**
* @author 作者 E-mail:牟胜杰
* @version 创建时间：2020年7月9日 上午10:37:24
*/
public interface ArticleMapper {
	
	/**
	 * @Description:(作用:查询所有文章列表)
	 * @param:@return   
	 * @return:List<Article>  
	 * @author:牟胜杰
	 * @date:2020年7月9日上午11:47:19
	 * @version:V1.0
	 * @param query 
	 */
	List<Article> findAll(ArticleQuery query);

	/**
	 * @Description:(作用:根据条件查询总条数)
	 * @param:@param query
	 * @param:@return   
	 * @return:Integer  
	 * @author:牟胜杰
	 * @date:2020年7月9日下午7:14:22
	 * @version:V1.0
	 */
	Integer findCount(ArticleQuery query);

	/**
	 * @Description:(作用:传入id调用方法进行删除)
	 * @param:@param id   
	 * @return:void  
	 * @author:牟胜杰
	 * @date:2020年7月10日下午1:19:38
	 * @version:V1.0
	 */
	void del(Long id);

	/**
	 * @Description:(作用:添加)
	 * @param:@param article   
	 * @return:void  
	 * @author:牟胜杰
	 * @date:2020年7月10日下午4:55:07
	 * @version:V1.0
	 */
	void add(Article article);
	
	/**
	 * @Description:(作用:修改)
	 * @param:@param article   
	 * @return:void  
	 * @author:牟胜杰
	 * @date:2020年7月10日下午4:55:07
	 * @version:V1.0
	 */
	void update(Article article);

	/**
	 * @Description:(作用:根据文章类型code进行查询文章)
	 * @param:@param technology
	 * @param:@return   
	 * @return:List<Article>  
	 * @author:牟胜杰
	 * @date:2020年7月12日上午11:17:24
	 * @version:V1.0
	 */
	List<Article> findArticleByCode(String code);

	/**
	 * @Description:(作用:根据id获取对象)
	 * @param:@param id
	 * @param:@return   
	 * @return:Article  
	 * @author:牟胜杰
	 * @date:2020年7月12日下午5:32:12
	 * @version:V1.0
	 */
	Article findById(Long id);

	/**
	 * @Description:(作用:根据url进行查询)
	 * @param:@param url
	 * @param:@return   
	 * @return:Article  
	 * @author:牟胜杰
	 * @date:2020年7月13日上午10:18:58
	 * @version:V1.0
	 */
	Article findByUrl(String url);
}
