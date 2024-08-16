package it.mbaziekone.book_e_commerce.service;

import java.util.List;

import it.mbaziekone.book_e_commerce.model.Product;

public interface ProductService {
	
	public List<Product> getAllCatalogs();
	
	public void saveProduct(Product product);
	
	public Product getProductById(Long id);
	
	public void deleteProduct(Long id);
	
}