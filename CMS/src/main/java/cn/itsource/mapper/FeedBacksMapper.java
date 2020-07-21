package cn.itsource.mapper;

import java.util.List;

import cn.itsource.domain.FeedBacks;
import cn.itsource.query.FeedBacksQuery;

/**
 * @Title: FeedBacksMapper.java
 * @author:牟胜杰
 * @Package:cn.itsource.mapper
 * @Description:(作用:好评如潮数据库持久层)
 * @date:2020年7月17日 下午2:23:26
 * @version:V1.0  
 */
public interface FeedBacksMapper {

	/**
	 * @Description:(作用:根据条件查询总条数)
	 * @param:@param query
	 * @param:@return   
	 * @return:Integer  
	 * @author:牟胜杰
	 * @date:2020年7月17日下午2:26:00
	 * @version:V1.0
	 */
	Integer findCount(FeedBacksQuery query);

	/**
	 * @Description:(作用:根据条件查询所有，分页)
	 * @param:@param query
	 * @param:@return   
	 * @return:List<FeedBacks>  
	 * @author:牟胜杰
	 * @date:2020年7月17日下午2:26:13
	 * @version:V1.0
	 */
	List<FeedBacks> findAll(FeedBacksQuery query);

	/**
	 * @Description:(作用:根据id查询数据)
	 * @param:@param id
	 * @param:@return   
	 * @return:FeedBacks  
	 * @author:牟胜杰
	 * @date:2020年7月17日下午3:02:56
	 * @version:V1.0
	 */
	FeedBacks findById(Long id);

	/**
	 * @Description:(作用:根据id删除数据)
	 * @param:@param id   
	 * @return:void  
	 * @author:牟胜杰
	 * @date:2020年7月17日下午3:03:10
	 * @version:V1.0
	 */
	void del(Long id);

	/**
	 * @Description:(作用:添加)
	 * @param:@param fBacks   
	 * @return:void  
	 * @author:牟胜杰
	 * @date:2020年7月17日下午3:14:35
	 * @version:V1.0
	 */
	void add(FeedBacks fBacks);

	/**
	 * @Description:(作用:修改)
	 * @param:@param fBacks   
	 * @return:void  
	 * @author:牟胜杰
	 * @date:2020年7月17日下午3:14:52
	 * @version:V1.0
	 */
	void update(FeedBacks fBacks);

	/**
	 * @Description:(作用:响应到前台，好评如潮)
	 * @param:@return   
	 * @return:List<FeedBacks>  
	 * @author:牟胜杰
	 * @date:2020年7月17日下午3:47:09
	 * @version:V1.0
	 */
	List<FeedBacks> getFeeds();

}
