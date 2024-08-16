package it.mbaziekone.book_e_commerce.service.impl;

import java.util.List;

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

}
