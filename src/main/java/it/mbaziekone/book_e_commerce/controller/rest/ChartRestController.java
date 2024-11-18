package it.mbaziekone.book_e_commerce.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.mbaziekone.book_e_commerce.repository.ProductRepository;

@RestController
@RequestMapping("/api/chart")
public class ChartRestController {
	
	private ProductRepository productRepository;
	
	public ChartRestController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
}
