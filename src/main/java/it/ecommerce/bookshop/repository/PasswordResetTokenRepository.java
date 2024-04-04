package it.ecommerce.bookshop.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.ecommerce.bookshop.model.User;
import it.ecommerce.bookshop.model.security.PasswordResetToken;
import java.util.Date;




public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
	
	
	public PasswordResetToken findByToken(String token);
	
	public PasswordResetToken findByUser(User user);
	
	public Stream<PasswordResetToken> findByExpiryDate(Date expiryDate);
	
	@Modifying
	@Query("DELETE FROM PasswordResetToken pst WHERE pst.expiryDate <= ?1")
	public void deleteAllExpiredSince(Date expiryDate);
	
}