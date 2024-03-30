package it.ecommerce.bookshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shopping_carts")
public class ShoppingCart implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shopping_cart_id")
	private int id;
	
	@Column(name = "grand_decimal")
	private BigDecimal granDecimal;
	
	private List<CartItem> cartItemList;
	
	private User user;

	public ShoppingCart() {
		super();
	}

	public ShoppingCart(BigDecimal granDecimal, List<CartItem> cartItemList, User user) {
		super();
		this.granDecimal = granDecimal;
		this.cartItemList = cartItemList;
		this.user = user;
	}
}