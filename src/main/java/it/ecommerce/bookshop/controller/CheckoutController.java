package it.ecommerce.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;

import it.ecommerce.bookshop.model.BillingAddress;
import it.ecommerce.bookshop.model.Payment;
import it.ecommerce.bookshop.model.ShippingAddress;
import it.ecommerce.bookshop.service.BillingAddressService;
import it.ecommerce.bookshop.service.CartItemService;
import it.ecommerce.bookshop.service.OrderService;
import it.ecommerce.bookshop.service.PaymentService;
import it.ecommerce.bookshop.service.ShippingAddressService;
import it.ecommerce.bookshop.service.ShoppingCartService;
import it.ecommerce.bookshop.service.UserPaymentService;
import it.ecommerce.bookshop.service.UserService;
import it.ecommerce.bookshop.service.UserShippingService;
import it.ecommerce.bookshop.utility.MailConstructor;

@Controller
public class CheckoutController {
	
	private ShippingAddress shippingAddress = new ShippingAddress();
	
	private BillingAddress billingAddress = new BillingAddress();
	
	private Payment payment = new Payment();
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private MailConstructor mailConstructor;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private ShippingAddressService shippingAddressService;
	
	@Autowired
	private BillingAddressService billingAddressService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private UserShippingService userShippingService;
	
	@Autowired
	private UserPaymentService userPaymentService;
	
	@Autowired
	private OrderService ordeService;

}
