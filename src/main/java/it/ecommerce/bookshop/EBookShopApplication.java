package it.ecommerce.bookshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "it.ecommerce.bookshop")
public class EBookShopApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EBookShopApplication.class, args);
	}
}