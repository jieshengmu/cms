package cn.itsource.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.itsource.domain.FeedBacks;
import cn.itsource.domain.Slide;
import cn.itsource.query.FeedBacksQuery;
import cn.itsource.query.SlideQuery;
import cn.itsource.service.IFeedBacksService;
import cn.itsource.util.AjaxResult;
import cn.itsource.util.PageBean;

/**
 * @Title: SlideController.java
 * @Package:cn.itsource.controller
 * @Description:(作用:轮播图后台)
 * @author:牟胜杰
 * @date:2020年7月13日 下午2:13:50
 * @version:V1.0  
 */
@Controller//创建对象，需要扫描包
@RequestMapping("/system/feedBacks")//代表后台的slide模块
public class FeedBacksController {
	@Autowired//依赖注入，给字段赋值
	private IFeedBacksService service;
	
	/**
	 * @Description:(作用:跳转到后台好评如潮管理页面)
	 * @param:@return   
	 * @return:String  
	 * @author:牟胜杰
	 * @date:2020年7月17日下午2:07:52
	 * @version:V1.0
	 */
	@RequestMapping("/index")
	public String goFeedBacksIndex() {
		return "feedbacks/feedbacks";
	}
	
	
	/**
	 * @Description:(作用:查询所有好评如潮图片)
	 * @param:@param query
	 * @param:@return   
	 * @return:PageBean<Slide>  
	 * @author:牟胜杰
	 * @date:2020年7月17日下午2:15:05
	 * @version:V1.0
	 */
	@RequestMapping("/list")//请求映射匹配
	@ResponseBody//返回json格式的数据，不会经过视图解析器
	public PageBean<FeedBacks> findAll(FeedBacksQuery query) {
		return service.findAll(query);
	}
	
	/**
	 * @Description:(作用:删除好评如潮图片)
	 * @param:@param id
	 * @param:@param req
	 * @param:@return   
	 * @return:AjaxResult  
	 * @author:牟胜杰
	 * @date:2020年7月17日下午2:58:37
	 * @version:V1.0
	 */
	@RequestMapping("/del")//请求映射匹配
	@ResponseBody//返回json格式的数据，不会经过视图解析器
	public AjaxResult del(Long id,HttpServletRequest req) {
		try {
			//传入id调用方法进行删除
			service.del(id,req);
			//没有发生返回对象AjaxResult，调用无参构造
			return new AjaxResult();
		} catch (Exception e) {
			e.printStackTrace();
			//发生错误返回对象AjaxResult,调用有参构造
			return new AjaxResult(false,"删除失败，请刷新后重新删除！");
		}
		
	}
	
	/**
	 * @Description:(作用:保存和修改方法)
	 * @param:@param slide
	 * @param:@param photo
	 * @param:@param req
	 * @param:@return   
	 * @return:AjaxResult  
	 * @author:牟胜杰
	 * @date:2020年7月17日下午3:10:14
	 * @version:V1.0
	 */
	@RequestMapping("/save")//请求映射匹配
	@ResponseBody//返回json格式的数据，不会经过视图解析器
	//MultipartFile  springmvc的上传对象，参数名必须和表单的name属性值相同
	public AjaxResult save(FeedBacks fBacks,MultipartFile photo,HttpServletRequest req) {
		try {
			//传入article对象调用方法进行保存
			service.save(fBacks,photo,req);
			//没有发生返回对象AjaxResult，调用无参构造
			return new AjaxResult();
		} catch (Exception e) {
			e.printStackTrace();
			//发生错误返回对象AjaxResult,调用有参构造
			return new AjaxResult(false,"上传失败，请重新上传！");
		}
		
	}
	
	
}
