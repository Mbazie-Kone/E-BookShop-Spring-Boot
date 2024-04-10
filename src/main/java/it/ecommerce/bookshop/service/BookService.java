package it.ecommerce.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ecommerce.bookshop.model.Book;
import it.ecommerce.bookshop.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> findByCategoryBooks(String category) {
		
		return bookRepository.findByCategory(category);
	}
}