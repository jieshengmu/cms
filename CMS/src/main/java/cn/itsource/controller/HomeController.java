package cn.itsource.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itsource.domain.Article;
import cn.itsource.domain.FAQ;
import cn.itsource.domain.FeedBacks;
import cn.itsource.domain.Slide;
import cn.itsource.service.IArticleService;
import cn.itsource.service.IFaqService;
import cn.itsource.service.IFeedBacksService;
import cn.itsource.service.ISlideService;
/**
 * @Title: ArticleController.java
 * @Package:cn.itsource.controller
 * @Description:(作用:跳转后台主页)
 * @author:牟胜杰
 * @date:2020年7月9日 上午11:42:38
 * @version:V1.0  
 */
@Controller//创建对象，扫描包
@RequestMapping("/home")
public class HomeController {
	@Autowired//依赖注入，字段赋值
	private IArticleService service;
	@Autowired//依赖注入，字段赋值
	private ISlideService slideService;
	@Autowired//依赖注入，字段赋值
	private IFaqService faqService;
	@Autowired//依赖注入，字段赋值
	private IFeedBacksService feedService;
	
	
	
	/**
	 * @Description:(作用:跳转到前台主页)
	 * @param:@return   
	 * @return:String  
	 * @author:牟胜杰
	 * @date:2020年7月12日上午11:05:14
	 * @version:V1.0
	 */
	@RequestMapping("/articles")//请求映射匹配
	@ResponseBody//将Java对象转换为json格式的数据，不经过视图解析器
	public Map<String, Object> articles() {
		//返回所有文章
		return service.getArticles();
	}
	
	
	/**
	 * @Description:(作用:增加点击次数)
	 * @param:@param url
	 * @param:@return   
	 * @return:Article  
	 * @author:牟胜杰
	 * @date:2020年7月15日上午10:50:08
	 * @version:V1.0
	 */
	@RequestMapping("/updateClickCount")//请求映射匹配
	@ResponseBody//将Java对象转换为json格式的数据，不经过视图解析器
	public Article updateClickCount(String url) {
		//返回所有文章
		return service.updateClickCount(url);
	}
	/**
	 * @Description:(作用:查询所有轮播图)
	 * @param:@return   
	 * @return:List<Slide>  
	 * @author:牟胜杰
	 * @date:2020年7月15日上午10:50:20
	 * @version:V1.0
	 */
	@RequestMapping("/slides")//请求映射匹配
	@ResponseBody//将Java对象转换为json格式的数据，不经过视图解析器
	public List<Slide> getSlides() {
		//返回所有轮播图
		return slideService.getSlides();
	}
	
	
	/**
	 * @Description:(作用:获取所有常见问题)
	 * @param:@return   
	 * @return:List<Slide>  
	 * @author:牟胜杰
	 * @date:2020年7月17日上午11:50:36
	 * @version:V1.0
	 */
	@RequestMapping("/faqs")//请求映射匹配
	@ResponseBody//将Java对象转换为json格式的数据，不经过视图解析器
	public List<FAQ> getFaqs() {
		//返回所有轮播图
		return faqService.getFaqs();
	}
	/**
	 * @Description:(作用:响应到前台，好评如潮)
	 * @param:@return   
	 * @return:List<FeedBacks>  
	 * @author:牟胜杰
	 * @date:2020年7月17日下午3:45:28
	 * @version:V1.0
	 */
	@RequestMapping("/feeds")//请求映射匹配
	@ResponseBody//将Java对象转换为json格式的数据，不经过视图解析器
	public List<FeedBacks> getFeeds() {
		//返回所有轮播图
		return feedService.getFeeds();
	}
	
	
	
	
	
}
