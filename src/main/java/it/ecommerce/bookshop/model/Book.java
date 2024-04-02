package it.ecommerce.bookshop.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;


/**
 * The persistent class for the books database table.
 * 
 */
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
	
	@Temporal(TemporalType.DATE)
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
	
	//bi-directional many-to-one association to BookToCartItem
	@OneToMany(mappedBy = "book")
	private List<BookToCartItem> bookToCartItems;
	
	//bi-directional many-to-one association to CartItem
	@OneToMany(mappedBy = "book")
	private List<CartItem> cartItems;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	public List<BookToCartItem> getBookToCartItems() {
		return bookToCartItems;
	}

	public void setBookToCartItems(List<BookToCartItem> bookToCartItems) {
		this.bookToCartItems = bookToCartItems;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	public BookToCartItem addBookToCartItem(BookToCartItem bookToCartItem) {
		getBookToCartItems().add(bookToCartItem);
		bookToCartItem.setBook(this);

		return bookToCartItem;
	}

	public BookToCartItem removeBookToCartItem(BookToCartItem bookToCartItem) {
		getBookToCartItems().remove(bookToCartItem);
		bookToCartItem.setBook(null);

		return bookToCartItem;
	}
	
	public CartItem addCartItem(CartItem cartItem) {
		getCartItems().add(cartItem);
		cartItem.setBook(this);

		return cartItem;
	}

	public CartItem removeCartItem(CartItem cartItem) {
		getCartItems().remove(cartItem);
		cartItem.setBook(null);

		return cartItem;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", publicationDate=" + publicationDate + ", language=" + language + ", category=" + category
				+ ", numberOfPages=" + numberOfPages + ", format=" + format + ", isbn=" + isbn + ", shippingWeight="
				+ shippingWeight + ", listPrice=" + listPrice + ", ourPrice=" + ourPrice + ", active=" + active
				+ ", description=" + description + ", inStockNumber=" + inStockNumber + ", bookImage=" + bookImage
				+ ", bookToCartItems=" + bookToCartItems + ", cartItems=" + cartItems + "]";
	}
}