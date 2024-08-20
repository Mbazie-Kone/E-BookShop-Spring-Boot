package it.mbaziekone.book_e_commerce.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import it.mbaziekone.book_e_commerce.model.Product;

public interface ProductService {
	
	public List<Product> getAllCatalogs();
	
	public void saveProduct(Product product, MultipartFile image);
	
	public Product getProductById(Long id);
	
	public void deleteProduct(Long id);
	
}