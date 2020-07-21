package cn.itsource.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.itsource.util.Constant;

/**
 * @Title: LoginInterceptor.java
 * @author:牟胜杰
 * @Package:cn.itsource.interceptor
 * @Description:(作用:拦截器)
 * @date:2020年7月16日 上午9:52:47
 * @version:V1.0  
 */
public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * @Description:(作用:请求处理完成时调用)
	 * @param:@param arg0
	 * @param:@param arg1
	 * @param:@param arg2
	 * @param:@param arg3
	 * @param:@throws Exception   
	 * @author:牟胜杰
	 * @date:2020年7月16日上午9:53:44
	 * @version:V1.0
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	/**
	 * @Description:(作用:执行处理器之后)
	 * @param:@param arg0
	 * @param:@param arg1
	 * @param:@param arg2
	 * @param:@param arg3
	 * @param:@throws Exception   
	 * @author:牟胜杰
	 * @date:2020年7月16日上午9:54:07
	 * @version:V1.0
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	/**
	 * @Description:(作用:在处理器执行之前)
	 * @param:@param arg0
	 * @param:@param arg1
	 * @param:@param arg2
	 * @param:@return
	 * @param:@throws Exception   
	 * @author:牟胜杰
	 * @date:2020年7月16日上午9:54:28
	 * @version:V1.0
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws Exception {
		//获取session
		HttpSession session = req.getSession();
		//通过session获取登录对象
		Object obj = session.getAttribute(Constant.USER_IN_SESSION);
		//判断是否登录过，obj是否为null
		if (obj == null) {//没有登录
			//重定向到登录界面
			resp.sendRedirect("/system/login");
			return false;
		}
		return true;//放行
	}
}
