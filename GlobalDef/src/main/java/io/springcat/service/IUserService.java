/**  
 * @Title: IUserService.java
 * @Prject: GlobalDef
 * @Package: io.springcat.service
 * @Description: TODO
 * @author: adampeng  
 * @date: 2015年2月26日 上午11:22:11
 * @version: V1.0  
 */
package io.springcat.service;

import io.springcat.vo.UserView;


/**
 * @ClassName: IUserService
 * @Description: TODO
 * @author: adampeng
 * @date: 2015年2月26日 上午11:22:11
 */
public interface IUserService {
	
	/**
	 * 
	* @Title: findUser 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param username
	* @param @return    设定文件 
	* @return UserView    返回类型 
	* @throws
	 */
	UserView findUserById(Long id);
	

}
