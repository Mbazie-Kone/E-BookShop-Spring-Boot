package it.ecommerce.bookshop.model.security;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import it.ecommerce.bookshop.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "password_reset_tokens")
public class PasswordResetToken implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final int EXPIRATION = 60 * 24;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "password_reset_token_id")
	private int id;
	
	private String token;
	
	@Column(name = "expiry_date")
	private Date expiryDate;
	
	public PasswordResetToken() {
		super();
	}

	public PasswordResetToken(final String token, final User user) {
		super();
		this.token = token;
		//this.user = user;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
	}

	private Date calculateExpiryDate(final int expiryTimeInMinutes) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(new Date().getTime());
		calendar.add(Calendar.MINUTE, expiryTimeInMinutes);
		
		return new Date(calendar.getTime().getTime());
	}
	
	public void updateToken(final String token) {
		this.token = token;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
	}
}