package it.ecommerce.bookshop.service;

import it.ecommerce.bookshop.dto.Purchase;
import it.ecommerce.bookshop.dto.PurchaseResponse;

public interface CheckoutService {
	
	PurchaseResponse placeOrder(Purchase purchase)

}
