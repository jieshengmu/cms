package cn.itsource.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Title: FAQ.java
 * @author:牟胜杰
 * @Package:cn.itsource.domain
 * @Description:(作用常见问题实体)
 * @date:2020年7月17日 上午9:19:08
 * @version:V1.0  
 */

public class FAQ {
	//id
	private Long id;
	//标题
	private String title;
	//内容
	private String content;
	//创建时间
	private Date createDate = new Date();
	//问题排序
	private Integer orderBy;
	
	public FAQ() {
	}

	public FAQ(Long id, String title, String content, Date createDate, Integer orderBy) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.orderBy = orderBy;
	}
	public FAQ(String title, String content, Date createDate, Integer orderBy) {
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.orderBy = orderBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	//pattern设置时间显示格式，timezone东八区
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}

	@Override
	public String toString() {
		return "[" + (id != null ? id + ", " : "") + (title != null ? title + ", " : "")
				+ (content != null ? content + ", " : "") + (createDate != null ? createDate + ", " : "")
				+ (orderBy != null ? orderBy : "") + "]";
	}
}
