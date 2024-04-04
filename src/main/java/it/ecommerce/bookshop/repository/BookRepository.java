package it.ecommerce.bookshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.ecommerce.bookshop.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	public List<Book> findByCategory(String category);
	
	public List<Book> findByTitleContaining(String title);
	
}