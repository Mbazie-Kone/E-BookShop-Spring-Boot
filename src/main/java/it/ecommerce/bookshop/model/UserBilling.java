package it.ecommerce.bookshop.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * The persistent class for the user_billings database table.
 * 
 */
@Entity
@Table(name = "user_billings")
public class UserBilling implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_billing_id")
	private Long id;
	
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
	
	@OneToOne(cascade = CascadeType.ALL)
	private UserPayment userPayment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserBillingName() {
		return userBillingName;
	}

	public void setUserBillingName(String userBillingName) {
		this.userBillingName = userBillingName;
	}

	public String getUserBillingStreet1() {
		return userBillingStreet1;
	}

	public void setUserBillingStreet1(String userBillingStreet1) {
		this.userBillingStreet1 = userBillingStreet1;
	}

	public String getUserBillingStreet2() {
		return userBillingStreet2;
	}

	public void setUserBillingStreet2(String userBillingStreet2) {
		this.userBillingStreet2 = userBillingStreet2;
	}

	public String getUserBillingCity() {
		return userBillingCity;
	}

	public void setUserBillingCity(String userBillingCity) {
		this.userBillingCity = userBillingCity;
	}

	public String getUserBillingCountry() {
		return userBillingCountry;
	}

	public void setUserBillingCountry(String userBillingCountry) {
		this.userBillingCountry = userBillingCountry;
	}

	public String getUserBillingZipCode() {
		return userBillingZipCode;
	}

	public void setUserBillingZipCode(String userBillingZipCode) {
		this.userBillingZipCode = userBillingZipCode;
	}

	public String getUserBillingState() {
		return userBillingState;
	}

	public void setUserBillingState(String userBillingState) {
		this.userBillingState = userBillingState;
	}

	public UserPayment getUserPayment() {
		return userPayment;
	}

	public void setUserPayment(UserPayment userPayment) {
		this.userPayment = userPayment;
	}

	@Override
	public String toString() {
		return "UserBilling [id=" + id + ", userBillingName=" + userBillingName + ", userBillingStreet1="
				+ userBillingStreet1 + ", userBillingStreet2=" + userBillingStreet2 + ", userBillingCity="
				+ userBillingCity + ", userBillingCountry=" + userBillingCountry + ", userBillingZipCode="
				+ userBillingZipCode + ", userBillingState=" + userBillingState + ", userPayment=" + userPayment + "]";
	}	
}