package cn.itsource.query;
/**
 * @Title: BaseQuery.java
 * @author:牟胜杰
 * @Package:cn.itsource.query
 * @Description:(作用:封装公共的查询条件)
 * @date:2020年7月9日 下午6:41:35
 * @version:V1.0  
 */
public class BaseQuery {
	/**当前页 */
	private Integer localPage;
	/**每页显示的条数 */
	private Integer pageSize;
	
	/**
	 * @Description:(作用:无参构造)
	 */
	public BaseQuery() {
	}
	/**
	 * @Description:(作用:有参构造)
	 */
	public BaseQuery(Integer localPage, Integer pageSize) {
		this.localPage = localPage;
		this.pageSize = pageSize;
	}
	
	/**
	 * @Description:(作用:设置bean属性)
	 * @param:@return   
	 * @return:Integer  
	 * @author:牟胜杰
	 * @date:2020年7月9日下午7:20:22
	 * @version:V1.0
	 */
	public Integer getBegin() {
		//设置分页查询的第一个参数
		return (this.localPage-1)*this.pageSize;
	}
	
	

	public Integer getLocalPage() {
		return localPage;
	}
	public void setLocalPage(Integer localPage) {
		this.localPage = localPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "[" + (localPage != null ? localPage + ", " : "") + (pageSize != null ? pageSize : "") + "]";
	}
	
}
