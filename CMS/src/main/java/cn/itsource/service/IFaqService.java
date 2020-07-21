package cn.itsource.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.itsource.domain.FAQ;
import cn.itsource.query.FaqQuery;
import cn.itsource.util.PageBean;

/**
 * @Title: IFaqService.java
 * @author:牟胜杰
 * @Package:cn.itsource.service
 * @Description:(作用:常见问题service层)
 * @date:2020年7月17日 上午9:58:38
 * @version:V1.0  
 */
public interface IFaqService {

	/**
	 * @Description:(作用:查询数据显示到后台列表)
	 * @param:@param query
	 * @param:@return   
	 * @return:PageBean<FAQ>  
	 * @author:牟胜杰
	 * @date:2020年7月17日上午10:00:14
	 * @version:V1.0
	 */
	PageBean<FAQ> findAll(FaqQuery query);

	/**
	 * @Description:(作用:根据id进行删除，常见问题)
	 * @param:@param id
	 * @return:void  
	 * @author:牟胜杰
	 * @date:2020年7月17日上午10:37:50
	 * @version:V1.0
	 */
	void del(Long id);

	/**
	 * @Description:(作用:保存和修改，常见问题)
	 * @param:@param faq   
	 * @return:void  
	 * @author:牟胜杰
	 * @date:2020年7月17日上午11:18:23
	 * @version:V1.0
	 */
	void save(FAQ faq);

	/**
	 * @Description:(作用:获取所有常见问题)
	 * @param:@return   
	 * @return:List<FAQ>  
	 * @author:牟胜杰
	 * @date:2020年7月17日上午11:51:00
	 * @version:V1.0
	 */
	List<FAQ> getFaqs();

}
