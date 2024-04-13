package it.ecommerce.bookshop.service;

import it.ecommerce.bookshop.model.Payment;
import it.ecommerce.bookshop.model.UserPayment;

public interface PaymentService {
	
	public Payment setByUserPayment(UserPayment userPayment, Payment payment);
	
}