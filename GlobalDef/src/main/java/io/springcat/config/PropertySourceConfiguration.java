/**
 * 
 */
package io.springcat.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * @author adampeng
 *
 */
@Configuration
public class PropertySourceConfiguration {

	@Bean
	public static PropertySourcesPlaceholderConfigurer defaultsPlaceHolderConfigurer() throws IOException {
	    PropertySourcesPlaceholderConfigurer propertyConfigurer = new PropertySourcesPlaceholderConfigurer();
	    propertyConfigurer.setLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/dal.properties"));
	    propertyConfigurer.setIgnoreUnresolvablePlaceholders(true);
	    return propertyConfigurer;
	}

//	@Bean
//	public static PropertySourcesPlaceholderConfigurer externalPlaceHolderConfigurer() throws IOException {
//	    PropertySourcesPlaceholderConfigurer propertyConfigurer = new PropertySourcesPlaceholderConfigurer();
//	    propertyConfigurer.setLocations(new
//	            PathMatchingResourcePatternResolver().getResources("file:/my-config-path/*.properties"));
//	    propertyConfigurer.setOrder(1);
//	    propertyConfigurer.setIgnoreUnresolvablePlaceholders(true);
//	    return propertyConfigurer;
//	}
	
}
