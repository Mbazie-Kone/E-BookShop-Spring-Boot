package it.ecommerce.bookshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ecommerce.bookshop.model.Book;
import it.ecommerce.bookshop.repository.BookRepository;
import it.ecommerce.bookshop.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> findAll() {
		
		return null;
	}

	@Override
	public Book findById(Long id) {
		
		return null;
	}

	@Override
	public List<Book> findByCategory(String category) {
		
		return null;
	}

	@Override
	public List<Book> findByTitle(String title) {
		
		return null;
	}
}