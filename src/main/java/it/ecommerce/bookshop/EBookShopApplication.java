package it.ecommerce.bookshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "it.ecommerce.bookshop.repository")
public class EBookShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(EBookShopApplication.class, args);
	}
}