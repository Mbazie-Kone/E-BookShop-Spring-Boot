package it.ecommerce.bookshop.model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders_item")
public class OrderItem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_item_id")
	private Long id;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "unit_price")
	private BigDecimal unitPrice;
	
	private int qty;
	
	@Column(name = "product_id")
	private Long productId;
	
	private Order order;
}
