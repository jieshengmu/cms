package cn.itsource.domain;
/**
* @author 作者 E-mail:牟胜杰
* @version 创建时间：2020年7月9日 上午10:32:50
* 文章类型
*/
public class ArticleType {
	/**文章类型Id*/
	private Long id;
	/**文章类型名字*/
	private String name;
	/**文章类型code*/
	private String code;

	/**
	 * @Description:(作用:无参构造)
	 */
	public ArticleType() {
	}

	/**
	 * @Description:(作用:有参构造)
	 */
	public ArticleType(Long id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "[" + (id != null ? id + ", " : "") + (name != null ? name + ", " : "") + (code != null ? code : "")
				+ "]";
	}

	
}
