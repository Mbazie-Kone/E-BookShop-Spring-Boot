package it.ecommerce.bookshop.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private String author;
	private String publisher;
	
	@Column(name = "publication_date")
	private Date publicationDate;
	
	private String language;
	private String category;
	
	@Column(name = "number_of_pages")
	private int numberOfPages;
	
	private String format;
	private int isbn;
	
	@Column(name = "shipping_weight")
	private double shippingWeight;
	
	@Column(name = "list_price")
	private double listPrice;
	
	@Column(name = "our_price")
	private double ourPrice;
	
	private boolean active = true;
}