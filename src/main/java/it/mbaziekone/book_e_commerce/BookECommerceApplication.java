package it.mbaziekone.book_e_commerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "it.mbaziekone.book_e_commerce")
public class BookECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookECommerceApplication.class, args);
	}
}