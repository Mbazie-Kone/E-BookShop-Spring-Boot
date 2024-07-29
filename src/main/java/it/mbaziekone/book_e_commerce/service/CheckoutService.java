package it.mbaziekone.book_e_commerce.service;

public interface CheckoutService {
	
	PurchaseResponse placeOrder(Purchase purchase);
}
