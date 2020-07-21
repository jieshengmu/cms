package cn.itsource.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller//创建对象
public class SessionController {

	/**
	 * @Description:(作用:session的创建和获取，如果有就获取，如果没有就创建)
	 * @param:@param resp
	 * @param:@throws UnsupportedEncodingException   
	 * @return:void  
	 * @author:牟胜杰
	 * @date:2020年7月15日下午2:20:32
	 * @version:V1.0
	 */
	@RequestMapping("/s1/get")//请求映射匹配
	public String addCookie(HttpServletRequest req,HttpSession session) {
		//如果有就获取；如果没有就创建session都是同一个对象
		System.out.println(req.getSession() == session );
		
		//设置session过期时间   30s,从不操作开始
		//session.setMaxInactiveInterval(30);
		//设置session
		session.setAttribute("name", "tom");
		session.setAttribute("age", 25);
		//获取session
		session.getAttribute("name");
		//移出session
		session.removeAttribute("name");
		
		return "redirect:/session.jsp";
		

	}


}
