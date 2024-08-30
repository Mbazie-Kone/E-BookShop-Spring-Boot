package it.mbaziekone.book_e_commerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import it.mbaziekone.book_e_commerce.model.Product;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

		HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
		
		// Disable HTTP methods for product: PUT, POST and DELETE
		config.getExposureConfiguration()
			.forDomainType(Product.class)
			.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
			.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

		
		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
	}
	
	
}
