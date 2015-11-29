/**  
 * @Title: User.java
 * @Prject: GlobalDef
 * @Package: io.springcat.bo
 * @Description: TODO
 * @author: adampeng  
 * @date: 2015年2月26日 上午11:21:33
 * @version: V1.0  
 */
package io.springcat.dto;

/**
 * @ClassName: User
 * @Description: TODO
 * @author: adampeng
 * @date: 2015年2月26日 上午11:21:33
 */
public class UserDTO extends BaseDTO{
	
	private static final long serialVersionUID = -4265114571895428359L;

	private String username;
	
	private String mobile;
	
	public UserDTO(){
		
	}
	
	public UserDTO(String username) {
		super();
		this.username = username;
	}
	
	public UserDTO(String username, String mobile) {
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
