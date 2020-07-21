package cn.itsource.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import cn.itsource.domain.FeedBacks;
import cn.itsource.query.FeedBacksQuery;
import cn.itsource.util.PageBean;

/**
 * @Title: IFeedBacksService.java
 * @author:牟胜杰
 * @Package:cn.itsource.service
 * @Description:(作用:好评如潮service层接口)
 * @date:2020年7月17日 下午2:18:17
 * @version:V1.0  
 */
public interface IFeedBacksService {

	/**
	 * @Description:(作用:查询所有好评如潮图片)
	 * @param:@param query
	 * @param:@return   
	 * @return:PageBean<FeedBacks>  
	 * @author:牟胜杰
	 * @date:2020年7月17日下午2:18:43
	 * @version:V1.0
	 */
	PageBean<FeedBacks> findAll(FeedBacksQuery query);

	/**
	 * @Description:(作用:根据id进行删除)
	 * @param:@param id
	 * @param:@param req   
	 * @return:void  
	 * @author:牟胜杰
	 * @date:2020年7月17日下午2:59:46
	 * @version:V1.0
	 */
	void del(Long id, HttpServletRequest req);

	/**
	 * @Description:(作用:保存和修改)
	 * @param:@param fBacks
	 * @param:@param photo
	 * @param:@param req   
	 * @return:void  
	 * @author:牟胜杰
	 * @date:2020年7月17日下午3:10:51
	 * @version:V1.0
	 * @throws IOException 
	 */
	void save(FeedBacks fBacks, MultipartFile photo, HttpServletRequest req) throws IOException;

	/**
	 * @Description:(作用:响应到前台，好评如潮)
	 * @param:@return   
	 * @return:List<FeedBacks>  
	 * @author:牟胜杰
	 * @date:2020年7月17日下午3:45:51
	 * @version:V1.0
	 */
	List<FeedBacks> getFeeds();

}
