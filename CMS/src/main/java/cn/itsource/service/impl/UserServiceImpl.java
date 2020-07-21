package cn.itsource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itsource.domain.User;
import cn.itsource.exception.AuthenticationException;
import cn.itsource.mapper.UserMapper;
import cn.itsource.service.IUserService;


/**
 * @Title: UserServiceImpl.java
 * @Package:cn.itsource.service.impl
 * @Description:(作用:登录)
 * @author:牟胜杰
 * @date:2020年7月15日 下午4:47:00
 * @version:V1.0  
 */
@Service//创建对象
public class UserServiceImpl implements IUserService {
	@Autowired//依赖注入，给字段赋值
	private UserMapper mapper;

	/**
	 * @Description:(作用:登录查询用户)
	 * @param:@param username
	 * @param:@param password
	 * @param:@return   
	 * @author:牟胜杰
	 * @date:2020年7月15日下午4:46:58
	 * @version:V1.0
	 * @throws Exception 
	 */
	@Override
	public User login(String username, String password) throws AuthenticationException {
		//先通过用户名进行查询数据库返回数据库对象
		User dbUser = mapper.findByUsername(username);
		//判断是否有该用户
		if (dbUser == null) {
			throw new AuthenticationException("没有该用户!");
		}else {//用户名是正确的，在判断密码
			if (!dbUser.getPassword().equals(password)) {
				throw new AuthenticationException("密码错误！");
			}else {
				//返回数据库对象
				return dbUser;
			}
			
		}
	}
	
}
