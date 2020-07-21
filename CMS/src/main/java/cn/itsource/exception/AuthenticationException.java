package cn.itsource.exception;
/**
 * @Title: AuthenticationException.java
 * @author:牟胜杰
 * @Package:cn.itsource.exception
 * @Description:(作用:自定义异常)
 * @date:2020年7月15日 下午6:53:30
 * @version:V1.0  
 */
public class AuthenticationException extends Exception {

	private static final long serialVersionUID = 6787649159132179408L;

	public AuthenticationException() {
		super();
	}

	public AuthenticationException(String message) {
		super(message);
	}
	

}
