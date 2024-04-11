package it.ecommerce.bookshop.service.impl;

import java.util.ArrayList;
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
		List<Book> books = (List<Book>) bookRepository.findAll();
		List<Book> activeBooks = new ArrayList<>();
		
		for (Book book : books) {
			if(book.isActive()) {
				activeBooks.add(book);
			}
		}
		
		return activeBooks;
	}

	@Override
	public Book findById(Long id) {
		
		return bookRepository.findById(id).orElse(null);
	}

	@Override
	public List<Book> findByCategory(String category) {
		
		List<Book> books = bookRepository.findByCategory(category);
		List<Book> activeBooks = new ArrayList<>();
		
		for (Book book : books) {
			if(book.isActive()) {
				activeBooks.add(book);
			}
		}
		
		return activeBooks;
	}

	@Override
	public List<Book> findByTitle(String title) {
		
		List<Book> books = bookRepository.findByTitle(title);
		List<Book> activeBooks = new ArrayList<>();
		
		for (Book book : books) {
			if(book.isActive()) {
				activeBooks.add(book);
			}
		}
		
		return activeBooks;
	}

	@Override
	public Book addBook(Book book) {
		
		Book b = bookRepository.save(book);
		
		return b;
	}

	@Override
	public Book updateBook(Book book) {
		
		Book b = bookRepository.save(book);
		
		return b;
	}

	@Override
	public void deleteBook(Book book) {
		
		bookRepository.delete(book);
	}
}