package cn.itsource.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import cn.itsource.domain.FAQ;
import cn.itsource.domain.Slide;
import cn.itsource.query.SlideQuery;
import cn.itsource.util.PageBean;

/**
 * @Title: ISlideService.java
 * @author:牟胜杰
 * @Package:cn.itsource.service
 * @Description:(作用)
 * @date:2020年7月13日 下午2:17:33
 * @version:V1.0  
 */
public interface ISlideService {

	/**
	 * @Description:(作用:根据条件查询)
	 * @param:@param query
	 * @param:@return   
	 * @return:PageBean<Slide>  
	 * @author:牟胜杰
	 * @date:2020年7月13日下午2:31:16
	 * @version:V1.0
	 */
	PageBean<Slide> findAll(SlideQuery query);

	/**
	 * @Description:(作用:文件上传)
	 * @param:@param slide
	 * @param:@param photo
	 * @param:@param req   
	 * @return:void  
	 * @author:牟胜杰
	 * @date:2020年7月13日下午4:20:14
	 * @version:V1.0
	 * @throws IOException 
	 */
	void save(Slide slide, MultipartFile photo, HttpServletRequest req) throws IOException;

	/**
	 * @Description:(作用:根据id进删除)
	 * @param:@param id
	 * @param:@param req   
	 * @return:void  
	 * @author:牟胜杰
	 * @date:2020年7月13日下午5:53:48
	 * @version:V1.0
	 */
	void del(Long id, HttpServletRequest req);

	/**
	 * @Description:(作用:查询所有轮播图)
	 * @param:@return   
	 * @return:List<Slide>  
	 * @author:牟胜杰
	 * @date:2020年7月15日上午10:50:35
	 * @version:V1.0
	 */
	List<Slide> getSlides();

	

}
