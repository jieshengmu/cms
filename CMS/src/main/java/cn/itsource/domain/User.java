package cn.itsource.domain;
/**
 * @Title: ss.java
 * @author:牟胜杰
 * @Package:cn.itsource.domain
 * @Description:(作用:用户实体类)
 * @date:2020年7月15日 下午4:10:36
 * @version:V1.0  
 */
public class User {
	private Long id;
	private String username;
	private String password;
	private String nickName;
	
	public User() {
	}

	public User(Long id, String username, String password, String nickName) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.nickName = nickName;
	}
	public User(String username, String password, String nickName) {
		this.username = username;
		this.password = password;
		this.nickName = nickName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "[" + (id != null ? id + ", " : "") + (username != null ? username + ", " : "")
				+ (password != null ? password + ", " : "") + (nickName != null ? nickName : "") + "]";
	}
}
