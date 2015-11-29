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

import io.springcat.dto.UserDTO;

import java.net.URL;
import java.util.List;


/**
 * @ClassName: IUserService
 * @Description: TODO
 * @author: adampeng
 * @date: 2015年2月26日 上午11:22:11
 */
public interface IUserService {
	
	/**
	 * 根据ID查询用户信息
	 * @param id
	 * @return
	 */
	UserDTO findUserById(Long id);
	
}
