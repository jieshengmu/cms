package cn.itsource.util;

import java.util.ArrayList;
import java.util.List;


/**
 * @Title: PageBean.java
 * @Package:cn.itsource.domain
 * @Description:(作用:用于接收data和totals方便下次使用)
 * @author:牟胜杰
 * @date:2020年7月9日 下午4:46:57
 * @version:V1.0  
 */
public class PageBean<T> {

	/**totals  分页的数据总条数 */
	private Integer totals = 0;
	/**查询的数据 赋值是为了避免空指针异常 */
	private List<T> data = new ArrayList<>();//创建对象

	/**
	 * @Description:(作用:有参构造)
	 */
	public PageBean() {
	}
	/**
	 * @Description:(作用:无参构造)
	 */
	public PageBean(Integer totals, List<T> data) {
		this.totals = totals;
		this.data = data;
	}


	public Integer getTotals() {
		return totals;
	}

	public void setTotals(Integer totals) {
		this.totals = totals;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "[" + (totals != null ? totals + ", " : "") + (data != null ? data : "") + "]";
	}







}
