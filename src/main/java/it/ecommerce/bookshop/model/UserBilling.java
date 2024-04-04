package it.ecommerce.bookshop.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy = "userBilling", cascade = CascadeType.ALL)
	private List<Payment> payments;
	
	//bi-directional many-to-one association to UserPayment
	@ManyToOne
	@JoinColumn(name = "user_payment_id")
	private UserPayment userPayment;
	
	//bi-directional many-to-one association to UserPayment
	@OneToMany(mappedBy = "userBilling", cascade = CascadeType.ALL)
	private List<UserPayment> userPayments;

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

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public UserPayment getUserPayment() {
		return userPayment;
	}

	public void setUserPayment(UserPayment userPayment) {
		this.userPayment = userPayment;
	}

	public List<UserPayment> getUserPayments() {
		return userPayments;
	}

	public void setUserPayments(List<UserPayment> userPayments) {
		this.userPayments = userPayments;
	}
	
	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setUserBilling(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setUserBilling(null);

		return payment;
	}
	
	public UserPayment addUserPayment(UserPayment userPayment) {
		getUserPayments().add(userPayment);
		userPayment.setUserBilling(this);

		return userPayment;
	}

	public UserPayment removeUserPayment(UserPayment userPayment) {
		getUserPayments().remove(userPayment);
		userPayment.setUserBilling(null);

		return userPayment;
	}

	@Override
	public String toString() {
		return "UserBilling [id=" + id + ", userBillingName=" + userBillingName + ", userBillingStreet1="
				+ userBillingStreet1 + ", userBillingStreet2=" + userBillingStreet2 + ", userBillingCity="
				+ userBillingCity + ", userBillingCountry=" + userBillingCountry + ", userBillingZipCode="
				+ userBillingZipCode + ", userBillingState=" + userBillingState + ", payments=" + payments
				+ ", userPayment=" + userPayment + ", userPayments=" + userPayments + "]";
	}
}