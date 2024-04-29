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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long id;
	
	@Column(name = "order_traking_number")
	private String orderTrakingNumber;
	
	@Column(name = "total_qty")
	private int totalQty;
	
	@Column(name = "total_price")
	private BigDecimal totalPrice;
	
	private String status;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_created")
	private Date dateCreated;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "last_updated")
	private Date lastUpdated;
	
	private Customer customer;
}
