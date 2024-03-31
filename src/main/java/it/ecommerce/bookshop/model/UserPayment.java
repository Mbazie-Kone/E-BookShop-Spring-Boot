package it.ecommerce.bookshop.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_payments")
public class UserPayment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_payment_id")
	private int id;
	
	private String type;
	
	@Column(name = "card_name")
	private String cardName;
	
	@Column(name = "card_number")
	private String cardNumber;
	
	@Column(name = "expire_month")
	private int expiryMonth;
	
	@Column(name = "expire_year")
	private int expiryYear;
	
	private int cvc;
	
	@Column(name = "holder_name")
	private String holderName;
	
	@Column(name = "default_payment")
	private boolean defaultPayment;

}