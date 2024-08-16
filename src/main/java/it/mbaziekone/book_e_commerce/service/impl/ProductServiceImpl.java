package it.mbaziekone.book_e_commerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.mbaziekone.book_e_commerce.model.Product;
import it.mbaziekone.book_e_commerce.repository.ProductRepository;
import it.mbaziekone.book_e_commerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllCatalogs() {
		return productRepository.findAll();
	}
	
	public void saveProduct(Product product) {
		productRepository.save(product);
	}
	
	public Product getProductById(Long id) {
		Optional<Product> optional = productRepository.findById(id);
		return optional.orElseThrow(() -> new RuntimeException("Product not found for ID :: " + id));
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);	
	}
}
