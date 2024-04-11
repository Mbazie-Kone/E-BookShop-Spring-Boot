package it.ecommerce.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ecommerce.bookshop.model.BillingAddress;
import it.ecommerce.bookshop.model.UserBilling;

public interface BillingAddressRepository extends JpaRepository<BillingAddress, Long> {
	
	public BillingAddress setByUserBilling(BillingAddress billingAddress, UserBilling userBilling);
}