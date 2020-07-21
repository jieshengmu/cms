package cn.itsource.service;

import cn.itsource.domain.User;
import cn.itsource.exception.AuthenticationException;

/**
 * @Title: IUserService.java
 * @Package:cn.itsource.service
 * @Description:(作用:用户登录)
 * @author:牟胜杰
 * @date:2020年7月15日 下午4:34:58
 * @version:V1.0  
 */
public interface IUserService {

	/**
	 * @Description:(作用:登录)
	 * @param:@param username
	 * @param:@param password
	 * @param:@return   
	 * @return:User  
	 * @author:牟胜杰
	 * @date:2020年7月15日下午4:46:44
	 * @version:V1.0
	 * @throws AuthenticationException 
	 * @throws Exception 
	 */
	User login(String username, String password) throws AuthenticationException, AuthenticationException;

	
	

}
