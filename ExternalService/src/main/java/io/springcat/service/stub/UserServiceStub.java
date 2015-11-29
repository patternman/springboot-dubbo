/**
 * 
 */
package io.springcat.service.stub;

import io.springcat.dto.UserDTO;
import io.springcat.service.IUserService;

/**
 * @author adampeng
 *
 */
public class UserServiceStub implements IUserService {

	private final IUserService userService;
	
	public UserServiceStub(IUserService userService) {
		this.userService = userService;
	}

	/* (non-Javadoc)
	 * @see io.springcat.service.IUserService#findUserById(java.lang.Long)
	 */
	@Override
	public UserDTO findUserById(Long id) {
		System.out.println("前置---------------------");
		return userService.findUserById(id);
	}

}
