package cn.itsource.mapper;

import java.util.List;

import cn.itsource.domain.ArticleType;

/**
* @author 作者 E-mail:牟胜杰
* @version 创建时间：2020年7月9日 上午10:37:24
*/
public interface ArticleTypeMapper {
	
	
	/**
	 * @Description:(作用:根据id查询文章类型)
	 * @param:@param id
	 * @param:@return   
	 * @return:ArticleType  
	 * @author:牟胜杰
	 * @date:2020年7月9日下午4:15:12
	 * @version:V1.0
	 */
	ArticleType findTypeById(Long id);
	
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
