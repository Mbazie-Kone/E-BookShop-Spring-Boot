package it.ecommerce.bookshop.model;

import jakarta.persistence.Entity;

@Entity
public class Book {
	
	private long id;
	private String title;
	private String author;
	private String publisher;
	private String publicationDate;
	private String language;
	private String category;
}