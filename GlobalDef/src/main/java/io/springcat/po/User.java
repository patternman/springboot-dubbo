/**  
 * @Title: User.java
 * @Prject: GlobalDef
 * @Package: io.springcat.po
 * @Description: TODO
 * @author: adampeng  
 * @version: V1.0  
 */
package io.springcat.po;


/**
 * @ClassName: User
 * @Description: TODO
 * @author: adampeng
 */
public class User extends IdEntity{
	
	private String username;
	
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	
}
