/**  
 * @Title: User.java
 * @Prject: GlobalDef
 * @Package: io.springcat.bo
 * @Description: TODO
 * @author: adampeng  
 * @date: 2015年2月26日 上午11:21:33
 * @version: V1.0  
 */
package io.springcat.vo;

/**
 * @ClassName: User
 * @Description: TODO
 * @author: adampeng
 * @date: 2015年2月26日 上午11:21:33
 */
public class UserView extends BaseView{
	
	private static final long serialVersionUID = -4265114571895428359L;

	private String username;
	
	private String mobile;
	
	public UserView(){
		
	}
	
	public UserView(String username) {
		super();
		this.username = username;
	}
	
	public UserView(String username, String mobile) {
		super();
		this.username = username;
		this.mobile = mobile;
	}

	/**
	 * getter method
	 * @return the username
	 */
	
	public String getUsername() {
		return username;
	}

	/**
	 * setter method
	 * @param username the username to set
	 */
	
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * getter method
	 * @return the mobile
	 */
	
	public String getMobile() {
		return mobile;
	}

	/**
	 * setter method
	 * @param mobile the mobile to set
	 */
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserView [username=" + username + ", mobile=" + mobile + "]";
	}
	
	

	
}
