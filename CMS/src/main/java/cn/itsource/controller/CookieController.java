package cn.itsource.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller//创建对象
public class CookieController {

	/**
	 * @Description:(作用:保存cookie)
	 * @param:@param resp
	 * @param:@throws UnsupportedEncodingException   
	 * @return:void  
	 * @author:牟胜杰
	 * @date:2020年7月15日下午2:20:32
	 * @version:V1.0
	 */
	@RequestMapping("/c1/add")//请求映射匹配
	public void addCookie(HttpServletResponse resp) throws UnsupportedEncodingException {
		//创建cookie对象
		Cookie c1 = new Cookie("id", "1");
		//立即删除 设置为0
		c1.setMaxAge(0);
		Cookie c2 = new Cookie("name", "tom");
		//保存到硬盘多少秒  大于0
		c2.setMaxAge(30);
		//解决中文乱码问题
		Cookie c3 = new Cookie("address", URLEncoder.encode("四川成都", "utf-8"));
		c3.setPath("/");//解决cookie跨域问题，扩大跨越的范围到根路径
		//保存cookie
		resp.addCookie(c1);
		resp.addCookie(c2);
		resp.addCookie(c3 );

		try {
			//告诉浏览器返回的是一个HTML页面，字符集为utf-8
			resp.setContentType("text/html;charset=utf-8");
			//打印输出到前台
			resp.getWriter().print("<h1>我来啦！</h1>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description:(作用:获取cookie)
	 * @param:@param req
	 * @param:@param resp
	 * @param:@throws IOException   
	 * @return:void  
	 * @author:牟胜杰
	 * @date:2020年7月15日下午2:20:18
	 * @version:V1.0
	 */
	@RequestMapping("/c1/find")//请求映射匹配
	public void findCookie(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		//告诉浏览器返回的是一个HTML，字符集为utf-8
		resp.setContentType("text/html;charset=utf-8");
		//获取到cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			//循环遍历cookies
			for (Cookie cookie : cookies) {
				//获取每一个cookiename和value
				String name = cookie.getName();
				String value =URLDecoder.decode(cookie.getValue(),"utf-8") ;
				resp.getWriter().print("<h1>"+name+"---"+ value +"</h1>");
			}
		}else {
			resp.getWriter().print("<h1>没有Cookie！！！</h1>");
		}



	}


}
