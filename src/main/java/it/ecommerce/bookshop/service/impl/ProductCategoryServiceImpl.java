package it.ecommerce.bookshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ecommerce.bookshop.repository.ProductCategoryRepository;
import it.ecommerce.bookshop.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Override
	public void findAll() {
		productCategoryRepository.findAll();
	}

}
