/**  
 * @Title: BaseView.java
 * @Prject: GlobalDef
 * @Package: io.springcat.vo
 * @Description: TODO
 * @author: adampeng  
 * @date: 2015年3月6日 下午2:02:49
 * @version: V1.0  
 */
package io.springcat.vo;

import java.io.Serializable;

/**
 * @ClassName: BaseView
 * @Description: TODO
 * @author: adampeng
 * @date: 2015年3月6日 下午2:02:49
 */
public class BaseView implements Serializable{

	/**
	  * @Fields serialVersionUID : TODO（用一句话描述这个变量表示什么）
	  */
	private static final long serialVersionUID = 1L;
	
	protected boolean flag;

	/**
	 * getter method
	 * @return the flag
	 */
	public boolean isFlag() {
		return flag;
	}

	/**
	 * setter method
	 * @param flag the flag to set
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
