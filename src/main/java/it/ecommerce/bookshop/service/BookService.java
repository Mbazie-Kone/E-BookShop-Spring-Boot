package it.ecommerce.bookshop.service;

import java.util.List;

import it.ecommerce.bookshop.model.Book;

public interface BookService {
	
	public List<Book> findAll();
	
	public Book findById(Long id);
	
	public List<Book> findByCategory(String category);
	
	public List<Book> findByTitle(String title);
	
	public Book addBook(Book book);
	
	public Book updateBook(Book book);
	
	public void deleteBook(Book book);

}