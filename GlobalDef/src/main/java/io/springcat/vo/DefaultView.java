/**  
 * @Title: DefaultView.java
 * @Prject: GlobalDef
 * @Package: io.springcat.vo
 * @Description: TODO
 * @author: adampeng  
 * @date: 2015年3月2日 下午11:45:37
 * @version: V1.0  
 */
package io.springcat.vo;


/**
 * @ClassName: DefaultView
 * @Description: TODO
 * @author: adampeng
 * @date: 2015年3月2日 下午11:45:37
 */
public class DefaultView extends BaseView {

	private static final long serialVersionUID = 7350839561682611292L;

	private String result;
	
	private String msg;

	/**
	 * getter method
	 * @return the result
	 */
	
	public String getResult() {
		return result;
	}

	/**
	 * setter method
	 * @param result the result to set
	 */
	
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * getter method
	 * @return the msg
	 */
	
	public String getMsg() {
		return msg;
	}

	/**
	 * setter method
	 * @param msg the msg to set
	 */
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
