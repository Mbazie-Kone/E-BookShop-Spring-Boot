package it.ecommerce.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import it.ecommerce.bookshop.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
}