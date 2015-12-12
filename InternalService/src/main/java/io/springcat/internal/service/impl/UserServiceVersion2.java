/**
 * 
 */
package io.springcat.internal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import io.springcat.dto.UserDTO;
import io.springcat.repository.mybatis.IUserDao;
import io.springcat.service.IUserService;
import io.springcat.util.BeanUtil;

/**
 * @author adampeng
 *
 */
public class UserServiceVersion2 implements IUserService {
	
	@Autowired
	IUserDao userDAO;

	/* (non-Javadoc)
	 * @see io.springcat.service.IUserService#findUserById(java.lang.Long)
	 */
	@Override
	public UserDTO findUserById(Long id) {
		return new UserDTO("Version2");
	}

}
