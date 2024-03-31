package it.ecommerce.bookshop.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private int id;
	
	private String type;
	
	@Column(name = "card_name")
	private String cardName;
	
	@Column(name = "card_number")
	private String cardNumber;
	
	@Column(name = "expiry_month")
	private int expiryMonth;
	
	@Column(name = "expiry_year")
	private int expiryYear;
	
	private int cvc;
	
	@Column(name = "holder_name")
	private String holderName;

}