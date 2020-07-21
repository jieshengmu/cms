package cn.itsource.query;
/**
 * @Title: FeedBacksQuery.java
 * @author:牟胜杰
 * @Package:cn.itsource.query
 * @Description:(作用:好评如潮私有参数)
 * @date:2020年7月17日 下午2:16:37
 * @version:V1.0  
 */
public class FeedBacksQuery extends BaseQuery{
	
	/**slide 高级查询好评如潮图片名称 */
	private String name;
	/**slide 高级查询好评如潮图片是否启用 */
	private Boolean enable;
	
	public FeedBacksQuery() {
	}

	public FeedBacksQuery(String name, Boolean enable) {
		this.name = name;
		this.enable = enable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "[" + (name != null ? name + ", " : "") + (enable != null ? enable : "") + "]";
	}

}
