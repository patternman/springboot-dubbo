/**  
 * @Title: Application.java
 * @Prject: InternalService
 * @Package: io.springcat.internal
 * @Description: TODO
 * @author: adampeng  
 * @date: 2015年3月3日 上午10:07:08
 * @version: V1.0  
 */
package io.springcat;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @ClassName: Application
 * @Description: TODO
 * @author: adampeng
 * @date: 2015年3月3日 上午10:07:08
 */
@Configuration
@EnableAutoConfiguration
@ImportResource("classpath:applicationContext.xml")
public class ServiceApplication {

	/**
	 * @Description: 无servlet容器模式启动
	 */
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ServiceApplication.class);
        app.setWebEnvironment(false); 
        ConfigurableApplicationContext ctx = app.run(args);
        while(true){
        	try {
				Thread.sleep(Long.MAX_VALUE);
			} catch (InterruptedException e) {}
        }
	}

}
