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

import io.springcat.repository.mybatis.IUserDao;

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
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param args 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ServiceApplication.class);
        app.setWebEnvironment(false); 
        ConfigurableApplicationContext ctx = app.run(args);
		IUserDao userDAO = (IUserDao)ctx.getBean("userDAO");
		System.out.println(userDAO.get(1L));
//		try {
//			System.in.read();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}
