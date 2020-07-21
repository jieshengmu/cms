package cn.itsource.mapper;

import java.util.List;

import cn.itsource.domain.Slide;
import cn.itsource.query.SlideQuery;

/**
 * @Title: SlideMapper.java
 * @author:牟胜杰
 * @Package:cn.itsource.mapper
 * @Description:(作用)
 * @date:2020年7月13日 下午2:34:32
 * @version:V1.0  
 */
public interface SlideMapper {

	/**
	 * @Description:(作用:根据条件查询内容)
	 * @param:@param query
	 * @param:@return   
	 * @return:List<Slide>  
	 * @author:牟胜杰
	 * @date:2020年7月13日下午2:34:59
	 * @version:V1.0
	 */
	List<Slide> findAll(SlideQuery query);

	/**
	 * @Description:(作用:根据条件查询数量)
	 * @param:@param query
	 * @param:@return   
	 * @return:Integer  
	 * @author:牟胜杰
	 * @date:2020年7月13日下午2:34:46
	 * @version:V1.0
	 */
	Integer findCount(SlideQuery query);

	/**
	 * @Description:(作用:添加图片)
	 * @param:@param slide   
	 * @return:void  
	 * @author:牟胜杰
	 * @date:2020年7月13日下午4:50:32
	 * @version:V1.0
	 */
	void add(Slide slide);

	/**
	 * @Description:(作用:更新)
	 * @param:@param slide   
	 * @return:void  
	 * @author:牟胜杰
	 * @date:2020年7月13日下午5:34:58
	 * @version:V1.0
	 */
	void update(Slide slide);

	/**
	 * @Description:(作用:根据id查询文件)
	 * @param:@param id
	 * @param:@return   
	 * @return:Slide  
	 * @author:牟胜杰
	 * @date:2020年7月13日下午5:57:19
	 * @version:V1.0
	 */
	Slide findById(Long id);

	/**
	 * @Description:(作用:根据id进行删除)
	 * @param:@param id   
	 * @return:void  
	 * @author:牟胜杰
	 * @date:2020年7月13日下午5:59:13
	 * @version:V1.0
	 */
	void del(Long id);

	/**
	 * @Description:(作用:查询所有轮播图)
	 * @param:@return   
	 * @return:List<Slide>  
	 * @author:牟胜杰
	 * @date:2020年7月15日上午10:51:35
	 * @version:V1.0
	 */
	List<Slide> getSlides();


}
