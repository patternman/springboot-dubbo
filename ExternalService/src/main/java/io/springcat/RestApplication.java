/**  
 * @Title: Application.java
 * @Prject: ExternalService
 * @Package: io.spring.external.service.run
 * @Description: TODO
 * @author: adampeng  
 * @date: 2015年2月27日 下午4:24:46
 * @version: V1.0  
 */
package io.springcat;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @ClassName: Application
 * @Description: TODO
 * @author: adampeng
 * @date: 2015年2月27日 下午4:24:46
 */
@SpringBootApplication
@ImportResource("classpath:consumer.xml")
public class RestApplication {

	/** 
	 * @Description: 前端启动方法
	 */
	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

}
