package it.mbaziekone.book_e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.mbaziekone.book_e_commerce.service.ProductService;

@Controller
@RequestMapping("/admin/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

}
