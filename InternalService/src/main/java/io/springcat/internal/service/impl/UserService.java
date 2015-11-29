/**  
 * @Title: UserService.java
 * @Prject: InternalService
 * @Package: io.springcat.internal.service.impl
 * @Description: TODO
 * @author: adampeng  
 * @date: 2015年2月26日 下午2:35:32
 * @version: V1.0  
 */
package io.springcat.internal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import io.springcat.dto.UserDTO;
import io.springcat.repository.mybatis.IUserDao;
import io.springcat.service.IUserService;
import io.springcat.util.BeanUtil;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @author: adampeng
 * @date: 2015年2月26日 下午2:35:32
 */
public class UserService implements IUserService {
	
	@Autowired
	IUserDao userDAO;

	@Override
	public UserDTO findUserById(Long id) {
		return BeanUtil.convertBean(userDAO.get(id), UserDTO.class);
	}

}
