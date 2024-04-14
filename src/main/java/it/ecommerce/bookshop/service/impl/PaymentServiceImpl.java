package it.ecommerce.bookshop.service.impl;

import org.springframework.stereotype.Service;

import it.ecommerce.bookshop.model.Payment;
import it.ecommerce.bookshop.model.UserPayment;
import it.ecommerce.bookshop.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Override
	public Payment setByUserPayment(UserPayment userPayment, Payment payment) {
		
		payment.setType(userPayment.getType());
		payment.setHolderName(userPayment.getHolderName());
		payment.setCardNumber(userPayment.getCardNumber());
		payment.setExpiryMonth(userPayment.getExpiryMonth());
		payment.setExpiryYear(userPayment.getExpiryYear());
		payment.setCvc(userPayment.getCvc());
			
		return payment;
	}

}