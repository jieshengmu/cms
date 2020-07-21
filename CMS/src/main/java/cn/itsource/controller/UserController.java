package cn.itsource.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itsource.domain.User;
import cn.itsource.exception.AuthenticationException;
import cn.itsource.service.IUserService;
import cn.itsource.util.AjaxResult;
import cn.itsource.util.Constant;
/**
 * @Title: UserController.java
 * @Package:cn.itsource.controller
 * @Description:(作用:跳转到后台登录界面)
 * @author:牟胜杰
 * @date:2020年7月15日 下午4:17:12
 * @version:V1.0  
 */
@Controller//创建对象
@RequestMapping("/system")//请求映射匹配
public class UserController {
	@Autowired//依赖注入，给字段赋值
	private IUserService service;
	
	/**
	 * @Description:(作用:跳转到后台登录界面)
	 * @param:@return   
	 * @return:String  
	 * @author:牟胜杰
	 * @date:2020年7月15日下午4:17:29
	 * @version:V1.0
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)//请求映射匹配
	public String goLogin() {
		return "login";
	}
	/**
	 * @Description:(作用:注销功能)
	 * @param:@param session
	 * @param:@return   
	 * @return:String  
	 * @author:牟胜杰
	 * @date:2020年7月15日下午7:29:07
	 * @version:V1.0
	 */
	@RequestMapping(value="/logout")//请求映射匹配
	public String logout(HttpSession session) {
		//session注销
		session.invalidate();
		//返回登录页面
		
		return "redirect:login";
	}
	/**
	 * @Description:(作用:后台登录)
	 * @param:@return   
	 * @return:String  
	 * @author:牟胜杰
	 * @date:2020年7月15日下午4:29:42
	 * @version:V1.0
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)//请求映射匹配
	@ResponseBody
	public AjaxResult toLogin(String username,String password,Integer remember,
			HttpSession session,HttpServletResponse resp,HttpServletRequest req) {
		
	try {
		//返回一个对象
		User user = service.login(username,password);
		//将登录信息放到session中
		session.setAttribute(Constant.USER_IN_SESSION, user);
		//判断是否勾了记住我，勾了就是不为null
		if (remember != null) {//点了记住我
			//创建cookie
			Cookie c1 = new Cookie(Constant.USERNAME, username);
			Cookie c2 = new Cookie(Constant.PASSWORD, password);
			//设置扩大Cooke作用范围，根路径有效
			c1.setPath("/");
			c2.setPath("/");
			//设置七天有效
			c1.setMaxAge(7*24*60*60);
			c2.setMaxAge(7*24*60*60);
			//保存cookie
			resp.addCookie(c1);
			resp.addCookie(c2);
		}else {//取消记住我
			//获取到所有的cookies
			Cookie[] cookies = req.getCookies();
			//循环遍历
			for (Cookie c : cookies) {
				//判断数组中是否包含username和password的cookie
				if (c.getName().equals(Constant.USERNAME) || c.getName().equals(Constant.PASSWORD) ) {
					//设置的时候，指定了/路径有效，所以在删除的时候/下的删除都有效
					c.setPath("/");
					//如果包含，我们就取消cookie,setMaxAge(0)等于0立即注销，删除
					c.setMaxAge(0);
					//删除之后加入resp才有效，因为之前已经添加到了数据包
					resp.addCookie(c);
				}
			}
			
			
		}
		return new AjaxResult();
	} catch (AuthenticationException e) {
		//e.printStackTrace();
		return new AjaxResult(false,e.getMessage());
	}
	}
}
