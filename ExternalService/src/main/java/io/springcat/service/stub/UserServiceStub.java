/**
 * 
 */
package io.springcat.service.stub;

import io.springcat.dto.UserDTO;
import io.springcat.service.IUserService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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
	public UserDTO findUserById(final Long id) {
		long timeout = 2000;
		System.out.println("前置---------------------");
		Future<UserDTO> userFuture = Executors.newFixedThreadPool(1).submit(new Callable<UserDTO>() {
			@Override
			public UserDTO call() throws Exception {
				return userService.findUserById(id);
			}
		});
//		UserDTO user = userService.findUserById(id);
		System.out.println("调用成功");
		try {
			return userFuture.get(timeout, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
		} catch (ExecutionException e) {
		} catch (TimeoutException e) {
		}
		return null;
	}

}
