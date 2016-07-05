/**
 * 
 */
package io.springcat.service;

/**
 * @author adampeng
 *
 */
public interface IOrderService {

	/**
	 * 创建订单
	 * @return
	 * @throws Exception
	 */
	boolean createOrder(Integer id) throws Exception;
	
}
