/**
 * 
 */
package io.springcat.external.controller;

import io.springcat.service.IOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author adampeng
 *
 */
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	@RequestMapping("/1")
	public boolean createOrder(){
		try {
			return orderService.createOrder(1);
		} catch (Exception e) {
			return false;
		}
	}

}
