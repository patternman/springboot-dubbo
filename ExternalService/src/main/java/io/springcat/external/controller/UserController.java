/**  
 * @Title: UserController.java
 * @Prject: ExternalService
 * @Package: io.spring.external.service
 * @Description: TODO
 * @author: adampeng  
 * @date: 2015年2月27日 下午3:50:46
 * @version: V1.0  
 */
package io.springcat.external.controller;

import io.springcat.dto.UserDTO;
import io.springcat.service.IUserService;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @author: adampeng
 * @date: 2015年2月27日 下午3:50:46
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public UserDTO getUser(@PathVariable("id") Long id){
		return userService.findUserById(id);
	}
	
}
