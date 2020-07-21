package cn.itsource.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Title: Slide.java
 * @author:牟胜杰
 * @Package:cn.itsource.domain
 * @Description:(作用轮播图实体类)
 * @date:2020年7月13日 下午12:54:46
 * @version:V1.0  
 */
public class Slide {
	/**id */
	private Long id;
	/**图片名 */
	private String name;
	/**图片路径 */
	private String path;
	/** 创建时间*/
	private Date createDate = new Date();
	/** 默认启用状态*/
	private Boolean enable;
	
	public Slide() {
	}

	public Slide(Long id, String name, String path, Date createDate, Boolean enable) {
		this.id = id;
		this.name = name;
		this.path = path;
		this.createDate = createDate;
		this.enable = enable;
	}
	public Slide( String name, String path, Date createDate, Boolean enable) {
		this.name = name;
		this.path = path;
		this.createDate = createDate;
		this.enable = enable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return
	 * @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	 * 规定响应到前台得json数据得时间格式，timezone表示时区，东8区=+8区
	 * 
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "[" + (id != null ? id + ", " : "") + (name != null ? name + ", " : "")
				+ (path != null ? path + ", " : "") + (createDate != null ? createDate + ", " : "")
				+ (enable != null ? enable : "") + "]";
	}
}
