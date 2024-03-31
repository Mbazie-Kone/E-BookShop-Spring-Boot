package it.ecommerce.bookshop.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "books")
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
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
	private String description;
	
	@Column(name = "in_stock_number")
	private int inStockNumber;
	
	@Transient
	private MultipartFile bookImage;
	
}