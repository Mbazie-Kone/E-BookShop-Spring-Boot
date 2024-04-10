package it.ecommerce.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.ecommerce.bookshop.model.Book;
import it.ecommerce.bookshop.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/view_books")
	public String BookList(ModelAndView model) {
		
		List<Book> books = bookService.findByCategoryBooks(null);
		
		model.addObject("book", books);
		
		return "booksList";
	}
}