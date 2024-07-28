package it.ecommerce.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	// Insert the product in the DB
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	// Update the product in the DB
	@PostMapping("/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable Long id, @RequestBody Product productDetails) {
		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
		product.setSku(productDetails.getSku());
		product.setName(productDetails.getName());
		product.setName(productDetails.getName());
		product.setDescription(productDetails.getDescription());
		return ResponseEntity.ok(productRepository.save(product));
	}
	
	// Delete the product from the DB
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
		productRepository.delete(product);
		return ResponseEntity.noContent().build();
	}
	
}
