package cn.itsource.query;

/**
 * @Title: ArticleQuery.java
 * @author:牟胜杰
 * @Package:cn.itsource.query
 * @Description:(作用：封装Article模块非公共的查询条件，用于高级查询)
 * @date:2020年7月9日 下午6:41:19
 * @version:V1.0  
 */
public class ArticleQuery extends BaseQuery{

	//文章标题
	private String title;

	//文章类型ID
	private Long typeId;

	//默认启用状态
	private Boolean enable;

	public ArticleQuery() {

	}

	public ArticleQuery(String title, Long typeId, Boolean enable) {
		this.title = title;
		this.typeId = typeId;
		this.enable = enable;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "[" + (title != null ? title + ", " : "") + (typeId != null ? typeId + ", " : "")
				+ (enable != null ? enable : "") + "]";
	}
	
	
	
	
}
