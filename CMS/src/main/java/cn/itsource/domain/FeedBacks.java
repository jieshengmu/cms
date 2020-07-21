package cn.itsource.domain;

import java.util.Date;

/**
 * @Title: FeedBacks.java
 * @author:牟胜杰
 * @Package:cn.itsource.domain
 * @Description:(作用:好评如潮实体)
 * @date:2020年7月17日 上午9:20:51
 * @version:V1.0  
 */
public class FeedBacks {
	//id
	private Long id;
	//图片名
	private String name;
	//图片路径
	private String path;
	//创建时间
	private Date createDate = new Date();
	 //默认启用状态
    private Boolean enable;
    
    
    public FeedBacks() {
	}


	public FeedBacks(Long id, String name, String path, Date createDate, Boolean enable) {
		this.id = id;
		this.name = name;
		this.path = path;
		this.createDate = createDate;
		this.enable = enable;
	}
	public FeedBacks( String name, String path, Date createDate, Boolean enable) {
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
