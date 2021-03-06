package cn.itsource.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.itsource.domain.Article;
import cn.itsource.domain.Slide;
import cn.itsource.query.SlideQuery;
import cn.itsource.service.ISlideService;
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
@RequestMapping("/system/slide")//代表后台的slide模块
public class SlideController {
	@Autowired//依赖注入，给字段赋值
	private ISlideService service;
	
	/**
	 * @Description:(作用:根据请求调整到主页面)
	 * @param:@return   
	 * @return:String  
	 * @author:牟胜杰
	 * @date:2020年7月13日下午2:14:09
	 * @version:V1.0
	 */
	@RequestMapping("/index")
	public String goSlideIndex() {
		return "slide/slide";
	}
	
	/**
	 * @Description:(作用:根据 条件进行查询)
	 * @param:@param query
	 * @param:@return   
	 * @return:PageBean<Slide>  
	 * @author:牟胜杰
	 * @date:2020年7月13日下午2:14:30
	 * @version:V1.0
	 */
	@RequestMapping("/list")//请求映射匹配
	@ResponseBody//返回json格式的数据，不会经过视图解析器
	public PageBean<Slide> findAll(SlideQuery query) {
		return service.findAll(query);
	}
	
	/**
	 * @Description:(作用:文件上传修改)
	 * @param:@param article
	 * @param:@param req
	 * @param:@return   
	 * @return:AjaxResult  
	 * @author:牟胜杰
	 * @date:2020年7月13日下午4:17:41
	 * @version:V1.0
	 */
	@RequestMapping("/save")//请求映射匹配
	@ResponseBody//返回json格式的数据，不会经过视图解析器
	//MultipartFile  springmvc的上传对象，参数名必须和表单的name属性值相同
	public AjaxResult save(Slide slide,MultipartFile photo,HttpServletRequest req) {
		try {
			//传入article对象调用方法进行保存
			service.save(slide,photo,req);
			//没有发生返回对象AjaxResult，调用无参构造
			return new AjaxResult();
		} catch (Exception e) {
			e.printStackTrace();
			//发生错误返回对象AjaxResult,调用有参构造
			return new AjaxResult(false,"上传失败，请重新上传！");
		}
		
	}
	
	/**
	 * @Description:(作用:根据id进行删除)
	 * @param:@param id
	 * @param:@param req
	 * @param:@return   
	 * @return:AjaxResult  
	 * @author:牟胜杰
	 * @date:2020年7月13日下午5:54:02
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
	

}
