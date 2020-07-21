package cn.itsource.query;
/**
 * @Title: FaqQuery.java
 * @author:牟胜杰
 * @Package:cn.itsource.query
 * @Description:(作用:常见问题私有参数)
 * @date:2020年7月17日 上午9:57:59
 * @version:V1.0  
 */
public class FaqQuery extends BaseQuery{
	
	/**常见问题标题 */
	private String title;
	
	public FaqQuery() {
	}

	public FaqQuery(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "[" + (title != null ? title : "") + "]";
	}

	
}
