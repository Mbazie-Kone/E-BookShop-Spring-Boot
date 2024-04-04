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
 * The persistent class for the user_payments database table.
 * 
 */
@Entity
@Table(name = "user_payments")
public class UserPayment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_payment_id")
	private Long id;
	
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
	
	//bi-directional many-to-one association to UserBilling
	@OneToMany(mappedBy = "userPayment", cascade = CascadeType.ALL)
	private List<UserBilling> userBillings;
	
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	//bi-directional many-to-one association to UserBilling
	@ManyToOne
	@JoinColumn(name = "user_billing_id")
	private UserBilling userBilling;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public int getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public boolean isDefaultPayment() {
		return defaultPayment;
	}

	public void setDefaultPayment(boolean defaultPayment) {
		this.defaultPayment = defaultPayment;
	}

	public List<UserBilling> getUserBillings() {
		return userBillings;
	}

	public void setUserBillings(List<UserBilling> userBillings) {
		this.userBillings = userBillings;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserBilling getUserBilling() {
		return userBilling;
	}

	public void setUserBilling(UserBilling userBilling) {
		this.userBilling = userBilling;
	}
	
	public UserBilling addUserBilling(UserBilling userBilling) {
		getUserBillings().add(userBilling);
		userBilling.setUserPayment(this);

		return userBilling;
	}

	public UserBilling removeUserBilling(UserBilling userBilling) {
		getUserBillings().remove(userBilling);
		userBilling.setUserPayment(null);

		return userBilling;
	}

	@Override
	public String toString() {
		return "UserPayment [id=" + id + ", type=" + type + ", cardName=" + cardName + ", cardNumber=" + cardNumber
				+ ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear + ", cvc=" + cvc + ", holderName="
				+ holderName + ", defaultPayment=" + defaultPayment + ", userBillings=" + userBillings + ", user="
				+ user + ", userBilling=" + userBilling + "]";
	}
}