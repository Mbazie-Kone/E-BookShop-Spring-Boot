package it.ecommerce.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ecommerce.bookshop.model.security.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

}