package it.ecommerce.bookshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int id;
	
	private Date orderDate;
	
	private Date shippingDate;
	
	private String shippingMethod;
	
	private String orderStatus;
	
	private BigDecimal orderTotal;
	
	private ShippingAddress shippingAddress;
	
	private BillingAddress billingAddress;
	
}