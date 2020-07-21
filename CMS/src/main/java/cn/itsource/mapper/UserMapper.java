package cn.itsource.mapper;

import cn.itsource.domain.User;

/**
 * @Title: UserMapper.java
 * @Package:cn.itsource.mapper
 * @Description:(作用:UserMapper层)
 * @author:牟胜杰
 * @date:2020年7月15日 下午4:36:32
 * @version:V1.0  
 */
public interface UserMapper {

	/**
	 * @Description:(作用:通过用户名查询用户)
	 * @param:@param username
	 * @param:@return   
	 * @return:User  
	 * @author:牟胜杰
	 * @date:2020年7月15日下午5:04:29
	 * @version:V1.0
	 */
	User findByUsername(String username);
	
}
