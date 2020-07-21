package cn.itsource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @Title: ArticleController.java
 * @Package:cn.itsource.controller
 * @Description:(作用:跳转后台主页)
 * @author:牟胜杰
 * @date:2020年7月9日 上午11:42:38
 * @version:V1.0  
 */
@Controller
@RequestMapping("/system")
public class SystemController {
	/**
	 * @Description:(作用:跳转到后台主页)
	 * @param:@return   
	 * @return:String  
	 * @author:牟胜杰
	 * @date:2020年7月9日下午1:00:57
	 * @version:V1.0
	 */
	@RequestMapping("/index")
	public String goIndex() {
		return "index";
	}
}
