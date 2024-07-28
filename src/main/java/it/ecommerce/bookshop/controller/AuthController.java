package it.ecommerce.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.ecommerce.bookshop.model.Product;
import it.ecommerce.bookshop.repository.ProductRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public Product createProduct(@RequestBody Product product) {
		
	}
	
	
}
