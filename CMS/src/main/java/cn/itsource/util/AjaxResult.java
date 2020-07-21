package cn.itsource.util;

/**
 * @Title: AjaxResult.java
 * @Package:cn.itsource.util
 * @Description:(作用:方便在controller层返回结果，可以直接调用无参构造和有参构造)
 * @author:牟胜杰
 * @date:2020年7月10日 下午2:32:20
 * @version:V1.0  
 */
public class AjaxResult {
	
	/**创建 success 赋值为true方便在controller层返回结果，可以直接调用无参构造*/
	private Boolean success = true;
	/**创建 msg 赋值为false方便在controller层返回结果，可以直接调用有参构造  设置值为false，并输入错误信息*/
	private String msg;
	
	public AjaxResult() {
	}

	public AjaxResult(Boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "[" + (success != null ? success + ", " : "") + (msg != null ? msg : "") + "]";
	}

}
