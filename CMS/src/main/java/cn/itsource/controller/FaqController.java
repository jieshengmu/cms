package cn.itsource.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.itsource.domain.FAQ;
import cn.itsource.domain.Slide;
import cn.itsource.query.FaqQuery;
import cn.itsource.service.IFaqService;
import cn.itsource.util.AjaxResult;
import cn.itsource.util.PageBean;

/**
 * @Title: Faq.java
 * @author:牟胜杰
 * @Package:cn.itsource.controller
 * @Description:(作用:常见问题现层)
 * @date:2020年7月17日 上午9:37:12
 * @version:V1.0  
 */
@Controller//创建对象
@RequestMapping("/system/faq")//请求映射匹配
public class FaqController {
	@Autowired//字段赋值
	private IFaqService service;
	
	
	@RequestMapping("/index")//请求映射匹配
	public String getFaqIndex() {
		//调转到常见问题列表页面
		return "faq/faq";
	}
	
	/**
	 * @Description:(作用:查询数据显示到后台列表)
	 * @param:@param query
	 * @param:@return   
	 * @return:PageBean<FAQ>  
	 * @author:牟胜杰
	 * @date:2020年7月17日上午10:00:19
	 * @version:V1.0
	 */
	@RequestMapping("/list")//请求映射匹配
	@ResponseBody//返回json格式的数据，不会经过视图解析器
	public PageBean<FAQ> findAll(FaqQuery query) {
		
		return service.findAll(query);
	}
	/**
	 * @Description:(作用:常见问题删除)
	 * @param:@param id
	 * @param:@return   
	 * @return:AjaxResult  
	 * @author:牟胜杰
	 * @date:2020年7月17日上午10:37:00
	 * @version:V1.0
	 */
	@RequestMapping("/del")//请求映射匹配
	@ResponseBody//返回json格式的数据，不会经过视图解析器
	public AjaxResult del(Long id,HttpServletRequest req) {
		try {
			//传入id调用方法进行删除
			service.del(id);
			//没有发生返回对象AjaxResult，调用无参构造
			return new AjaxResult();
		} catch (Exception e) {
			e.printStackTrace();
			//发生错误返回对象AjaxResult,调用有参构造
			return new AjaxResult(false,"删除失败，请刷新后重新删除！");
		}
		
	}
	
	
	/**
	 * @Description:(作用:保存和修改，常见问题)
	 * @param:@param slide
	 * @param:@param photo
	 * @param:@param req
	 * @param:@return   
	 * @return:AjaxResult  
	 * @author:牟胜杰
	 * @date:2020年7月17日上午11:17:04
	 * @version:V1.0
	 */
	@RequestMapping("/save")//请求映射匹配
	@ResponseBody//返回json格式的数据，不会经过视图解析器
	public AjaxResult save(FAQ faq) {
		try {
			//传入faq对象调用方法进行保存
			service.save(faq);
			//没有发生返回对象AjaxResult，调用无参构造
			return new AjaxResult();
		} catch (Exception e) {
			e.printStackTrace();
			//发生错误返回对象AjaxResult,调用有参构造
			return new AjaxResult(false,"保存失败，请重新保存！");
		}
		
	}
	
	

}
