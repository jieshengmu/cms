package cn.itsource.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @author 作者 E-mail:牟胜杰
* @version 创建时间：2020年7月9日 上午10:32:20
*/
public class Article {
	//主键id
	private Long id;
	//文章标题
	private String title;
	//文章url地址
	private String url;
	//文章类型ID
	private Long typeId;
	//文章类型
	private ArticleType type;
	//点击次数
	private Integer clickCount = 0;
	//文章内容
	private String content;
	//创建时间
	private Date createDate = new Date();
	//默认启用状态
	private Boolean enable;
	
	
	/**
	 * @Description:(作用:无参构造)
	 */
	public Article() {
	}

	/**
	 * @Description:(作用:有参构造，带id)
	 */
	public Article(Long id, String title, String url, Long typeId, ArticleType type, Integer clickCount, String content,
			Date createDate, Boolean enable) {
		this.id = id;
		this.title = title;
		this.url = url;
		this.typeId = typeId;
		this.type = type;
		this.clickCount = clickCount;
		this.content = content;
		this.createDate = createDate;
		this.enable = enable;
	}
	/**
	 * @Description:(作用:有参构造，不带id)
	 */
	public Article( String title, String url, Long typeId, ArticleType type, Integer clickCount, String content,
			Date createDate, Boolean enable) {
		this.title = title;
		this.url = url;
		this.typeId = typeId;
		this.type = type;
		this.clickCount = clickCount;
		this.content = content;
		this.createDate = createDate;
		this.enable = enable;
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


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public Long getTypeId() {
		return typeId;
	}


	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}


	public ArticleType getType() {
		return type;
	}


	public void setType(ArticleType type) {
		this.type = type;
	}


	public Integer getClickCount() {
		return clickCount;
	}


	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
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


	/**
	 * @Description:(作用:重写toString方法)
	 * @param:@return   
	 * @author:牟胜杰
	 * @date:2020年7月9日下午7:53:18
	 * @version:V1.0
	 */
	@Override
	public String toString() {
		return "[" + (id != null ? id + ", " : "") + (title != null ? title + ", " : "")
				+ (url != null ? url + ", " : "") + (typeId != null ? typeId + ", " : "")
				+ (type != null ? type + ", " : "") + (clickCount != null ? clickCount + ", " : "")
				+ (content != null ? content + ", " : "") + (createDate != null ? createDate + ", " : "")
				+ (enable != null ? enable : "") + "]";
	}
	
	
	
	


}
