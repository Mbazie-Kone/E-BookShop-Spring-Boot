package it.ecommerce.bookshop.model.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;

public class BookDto {
	
	@NotEmpty(message = "Book title is required")
	private String title;
	
	@NotEmpty(message = "Book author is required")
	private String author;
	
	@NotEmpty(message = "Book publisher is required")
	private String publisher;
	
	@NotEmpty(message = "Book publication date is required")
	private Date publicationDate;
	
	@NotEmpty(message = "Book category is required")
	private String category;
	
	private String format;
	
	@NotEmpty(message = "Book isbn is required")
	private int isbn;
	
	private double shippingWeight;
	
	@NotEmpty(message = "Book list price is required")
	private double listPrice;
	
	@NotEmpty(message = "Book our price is required")
	private double ourPrice;
	
	private String description;
	
	@NotEmpty(message = "Book in stock number is required")
	private int inStockNumber;
	
	private MultipartFile bookImage;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public double getShippingWeight() {
		return shippingWeight;
	}

	public void setShippingWeight(double shippingWeight) {
		this.shippingWeight = shippingWeight;
	}

	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	public double getOurPrice() {
		return ourPrice;
	}

	public void setOurPrice(double ourPrice) {
		this.ourPrice = ourPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getInStockNumber() {
		return inStockNumber;
	}

	public void setInStockNumber(int inStockNumber) {
		this.inStockNumber = inStockNumber;
	}

	public MultipartFile getBookImage() {
		return bookImage;
	}

	public void setBookImage(MultipartFile bookImage) {
		this.bookImage = bookImage;
	}
}
