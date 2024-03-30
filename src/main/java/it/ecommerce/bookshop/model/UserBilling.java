package it.ecommerce.bookshop.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_billings")
public class UserBilling implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_billing_id")
	private int id;
	
	@Column(name = "user_billing_name")
	private String userBillingName;
	
	@Column(name = "user_billing_street_1")
	private String userBillingStreet1;
	
	@Column(name = "user_billing_street_2")
	private String userBillingStreet2;
	
	@Column(name = "user_billing_city")
	private String userBillingCity;
	
	@Column(name = "user_billing_country")
	private String userBillingCountry;
	
	@Column(name = "user_billing_zip_code")
	private String userBillingZipCode;
	
	@Column(name = "user_billing_state")
	private String userBillingState;

}