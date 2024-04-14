package it.ecommerce.bookshop.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * The persistent class for the user_shippings database table.
 * 
 */
@Entity
@Table(name = "user_shipping")
public class UserShipping implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_shipping_id")
	private Long id;
	
	@Column(name = "user_shipping_name")
	private String userShippingName;
	
	@Column(name = "user_shipping_street_1")
	private String userShippingStreet1;
	
	@Column(name = "user_shipping_street_2")
	private String userShippingStreet2;
	
	@Column(name = "user_shipping_city")
	private String userShippingCity;
	
	@Column(name = "user_shipping_country")
	private String userShippingCountry;
	
	@Column(name = "user_shipping_zip_code")
	private String userShippingZipCode;
	
	@Column(name = "user_shipping_state")
	private String userShippingState;
	
	@Column(name = "user_shipping_default")
	private boolean userShippingDefault;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserShippingName() {
		return userShippingName;
	}

	public void setUserShippingName(String userShippingName) {
		this.userShippingName = userShippingName;
	}

	public String getUserShippingStreet1() {
		return userShippingStreet1;
	}

	public void setUserShippingStreet1(String userShippingStreet1) {
		this.userShippingStreet1 = userShippingStreet1;
	}

	public String getUserShippingStreet2() {
		return userShippingStreet2;
	}

	public void setUserShippingStreet2(String userShippingStreet2) {
		this.userShippingStreet2 = userShippingStreet2;
	}

	public String getUserShippingCity() {
		return userShippingCity;
	}

	public void setUserShippingCity(String userShippingCity) {
		this.userShippingCity = userShippingCity;
	}

	public String getUserShippingCountry() {
		return userShippingCountry;
	}

	public void setUserShippingCountry(String userShippingCountry) {
		this.userShippingCountry = userShippingCountry;
	}

	public String getUserShippingZipCode() {
		return userShippingZipCode;
	}

	public void setUserShippingZipCode(String userShippingZipCode) {
		this.userShippingZipCode = userShippingZipCode;
	}

	public String getUserShippingState() {
		return userShippingState;
	}

	public void setUserShippingState(String userShippingState) {
		this.userShippingState = userShippingState;
	}

	public boolean isUserShippingDefault() {
		return userShippingDefault;
	}

	public void setUserShippingDefault(boolean userShippingDefault) {
		this.userShippingDefault = userShippingDefault;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserShipping [id=" + id + ", userShippingName=" + userShippingName + ", userShippingStreet1="
				+ userShippingStreet1 + ", userShippingStreet2=" + userShippingStreet2 + ", userShippingCity="
				+ userShippingCity + ", userShippingCountry=" + userShippingCountry + ", userShippingZipCode="
				+ userShippingZipCode + ", userShippingState=" + userShippingState + ", userShippingDefault="
				+ userShippingDefault + ", user=" + user + "]";
	}
}