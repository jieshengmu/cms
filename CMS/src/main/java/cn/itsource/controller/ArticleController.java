package cn.itsource.controller;

import java.util.List;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itsource.domain.Article;
import cn.itsource.domain.ArticleType;
import cn.itsource.query.ArticleQuery;
import cn.itsource.service.IArticleService;
import cn.itsource.service.IArticleTypeService;
import cn.itsource.util.AjaxResult;
import cn.itsource.util.PageBean;
/**
 * @Title: ArticleController.java
 * @Package:cn.itsource.controller
 * @Description:(作用:后台文章管理)
 * @author:牟胜杰
 * @date:2020年7月9日 上午11:42:38
 * @version:V1.0  
 */
@Controller//创建对象，需要扫描包
@RequestMapping("/system/article")//代表后台的article模块
public class ArticleController {
	@Autowired//依赖注入，会根据当前字段类型去查询后，给字段赋值
	private IArticleService service;
	@Autowired//依赖注入，会根据当前字段类型去查询后，给字段赋值
	private IArticleTypeService typeService;
	/**
	 * @Description:(作用:调转到文章模块的首页，并传递文章类型到前台高级查询下拉框)
	 * @param:@return   
	 * @return:String  
	 * @author:牟胜杰
	 * @date:2020年7月9日下午2:11:45
	 * @version:V1.0
	 */
	@RequestMapping("/index")
	public String goArticleIndex(Model model) {
		//接收查询到的所有文章类型
		List<ArticleType> types = typeService.findTypeAll();
		//将文章类型传递到前台，用于高级查询动态展示
		model.addAttribute("types", types);
		//调转到文章列表页面
		return "article/article";
	}
	/**
	 * @Description:(作用:查询所有文章数据，也可以根据条件进行查询，如果根据条件 查询到的数据为空，显示的数据也为0条)
	 * @param:@return   
	 * @return:Map<String,Object>  
	 * @author:牟胜杰
	 * @date:2020年7月9日下午2:56:15
	 * @version:V1.0
	 */
	@RequestMapping("/list")//请求映射匹配
	@ResponseBody//返回json格式的数据，不会经过视图解析器
	public PageBean<Article> findAll(ArticleQuery query) {
		
		//将查询返回的数据，需要的格式data和totals封装到PageBean中，方便每一次查询分页的时候使用
		
		/*//接收查询的数据
		List<Article> data = service.findAll();
		//创建hashmap对象，返回GirdManager需要的数据格式 "data" "totals"
		Map<String, Object> map = new HashMap<>();
		//将查询到的数据存入hashmap中
		map.put("data", data);
		//将数据总数存入hashmap中data.size()总数
		map.put("totals", data.size());*/
		//返回map集合
		return service.findAll(query);
	}
	
	
	
	
	/**
	 * @Description:(作用:传入id调用方法进行删除操作)
	 * @param:@param id
	 * @param:@return   
	 * @return:String  
	 * @author:牟胜杰
	 * @date:2020年7月10日下午1:18:29
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
	 * @Description:(作用:添加和修改)
	 * @param:@param query
	 * @param:@return   
	 * @return:AjaxResult  
	 * @author:牟胜杰
	 * @date:2020年7月10日下午4:45:06
	 * @version:V1.0
	 */
	@RequestMapping("/save")//请求映射匹配
	@ResponseBody//返回json格式的数据，不会经过视图解析器
	public AjaxResult save(Article article,HttpServletRequest req) {
		try {
			//传入article对象调用方法进行保存
			service.save(article,req);
			//没有发生返回对象AjaxResult，调用无参构造
			return new AjaxResult();
		} catch (Exception e) {
			e.printStackTrace();
			//发生错误返回对象AjaxResult,调用有参构造
			return new AjaxResult(false,"保存失败，请重新保存！");
		}
		
	}
	

}
