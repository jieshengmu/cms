package cn.itsource.mapper;

import java.util.List;

import cn.itsource.domain.FAQ;
import cn.itsource.query.FaqQuery;

/**
 * @Title: FaqMapper.java
 * @author:牟胜杰
 * @Package:cn.itsource.mapper
 * @Description:(作用常见问题数据库持久层)
 * @date:2020年7月17日 上午10:04:40
 * @version:V1.0  
 */
public interface FaqMapper {

	/**
	 * @Description:(作用:查询所有常见问题)
	 * @param:@param query
	 * @param:@return   
	 * @return:List<FAQ>  
	 * @author:牟胜杰
	 * @date:2020年7月17日上午10:05:56
	 * @version:V1.0
	 */
	List<FAQ> findAll(FaqQuery query);

	/**
	 * @Description:(作用:根据条件查询常见问题总条数)
	 * @param:@param query
	 * @param:@return   
	 * @return:Integer  
	 * @author:牟胜杰
	 * @date:2020年7月17日上午10:06:17
	 * @version:V1.0
	 */
	Integer findCount(FaqQuery query);
	/**
	 * @Description:(作用:根据id进行删除)
	 * @param:@param id   
	 * @author:牟胜杰
	 * @date:2020年7月17日上午10:39:57
	 * @version:V1.0
	 */
	void del(Long id);

	/**
	 * @Description:(作用:添加，常见问题)
	 * @param:@param faq   
	 * @return:void  
	 * @author:牟胜杰
	 * @date:2020年7月17日上午11:21:19
	 * @version:V1.0
	 */
	void add(FAQ faq);

	/**
	 * @Description:(作用:修改，常见问题)
	 * @param:@param faq   
	 * @return:void  
	 * @author:牟胜杰
	 * @date:2020年7月17日上午11:21:35
	 * @version:V1.0
	 */
	void update(FAQ faq);

	/**
	 * @Description:(作用:获取所有常见问题)
	 * @param:@return   
	 * @return:List<FAQ>  
	 * @author:牟胜杰
	 * @date:2020年7月17日上午11:54:40
	 * @version:V1.0
	 */
	List<FAQ> faqs(); 
}
