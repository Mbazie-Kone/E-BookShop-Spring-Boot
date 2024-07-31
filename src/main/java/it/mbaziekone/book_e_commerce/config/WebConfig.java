package it.mbaziekone.book_e_commerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

public class WebConfig implements WebMvcConfigurer {
	
	@Bean	
	ThymeleafViewResolver thymeleafViewResolver() {
		
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
	}
	
	
	

}
