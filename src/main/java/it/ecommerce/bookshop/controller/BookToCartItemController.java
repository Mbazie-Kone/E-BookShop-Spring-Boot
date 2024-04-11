package it.ecommerce.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import it.ecommerce.bookshop.service.BookToCartItemService;

@Controller
public class BookToCartItemController {
	
	@Autowired
	private BookToCartItemService bookToCartItemService;
}
