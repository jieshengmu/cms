package cn.itsource.query;

/**
 * @Title: SlideQuery.java
 * @Package:cn.itsource.query
 * @Description:(作用:封装slide轮播图模块非公共的查询条件，用于高级查询)
 * @author:牟胜杰
 * @date:2020年7月13日 下午1:03:21
 * @version:V1.0  
 */
public class SlideQuery extends BaseQuery{
	/**slide 高级查询图片名称 */
	private String name;
	/**slide 高级查询是否启用 */
	private Boolean enable;
	
	public SlideQuery() {
	}

	public SlideQuery(String name, Boolean enable) {
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
