package it.ecommerce.bookshop.controller;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.ecommerce.bookshop.model.BillingAddress;
import it.ecommerce.bookshop.model.CartItem;
import it.ecommerce.bookshop.model.Payment;
import it.ecommerce.bookshop.model.ShippingAddress;
import it.ecommerce.bookshop.model.ShoppingCart;
import it.ecommerce.bookshop.model.User;
import it.ecommerce.bookshop.model.UserPayment;
import it.ecommerce.bookshop.model.UserShipping;
import it.ecommerce.bookshop.service.BillingAddressService;
import it.ecommerce.bookshop.service.CartItemService;
import it.ecommerce.bookshop.service.OrderService;
import it.ecommerce.bookshop.service.PaymentService;
import it.ecommerce.bookshop.service.ShippingAddressService;
import it.ecommerce.bookshop.service.ShoppingCartService;
import it.ecommerce.bookshop.service.UserPaymentService;
import it.ecommerce.bookshop.service.UserService;
import it.ecommerce.bookshop.service.UserShippingService;
import it.ecommerce.bookshop.utility.ITConstants;
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
	private OrderService orderService;
	
	@GetMapping("/checkout")
	public String checkout(@RequestParam("id") Long cartId, @RequestParam(value = "missingRequiredField", required = false)
	boolean missingRequiredField, Model model, Principal principal) {
		
		User user = userService.findByUsername(principal.getName());
		
		if(cartId != user.getShoppingCart().getId()) {
			
			return "badRequestPage";
		}
		
		List<CartItem> cartItems = cartItemService.findByShoppingCart(user.getShoppingCart());
		
		if(cartItems.size() == 0) {
			model.addAttribute("emptyCart", true);
			
			return "forward:/shoppingCart/cart";
		}
		
		for (CartItem cartItem : cartItems) {
			if(cartItem.getBook().getInStockNumber() < cartItem.getQty()) {
				model.addAttribute("noEnoughStock", true);
				
				return "forward:/shoppingCart/cart";
			}
		}
		
		List<UserShipping> userShippings = user.getUserShippings();
		List<UserPayment> userPayments = user.getUserPayments();
		
		model.addAttribute("userShippings", userShippings);
		model.addAttribute("userPayments", userPayments);
		
		if(userPayments.size() == 0) {
			model.addAttribute("emptyPaymentList", true);
		}
		else {
			model.addAttribute("emptyPaymentList", false);
		}
		
		if(userShippings.size() == 0) {
			model.addAttribute("emptyShippingtList", true);
		}
		else {
			model.addAttribute("emptyShippingList", false);
		}
		
		ShoppingCart shoppingCart = user.getShoppingCart();
		
		for (UserShipping userShipping : userShippings) {
			if(userShipping.isUserShippingDefault()) {
				shippingAddressService.setByUserShipping(userShipping, shippingAddress);
			}	
		}
		
		for (UserPayment userPayment : userPayments) {
			if(userPayment.isDefaultPayment()) {
				paymentService.setByUserPayment(userPayment, payment);
				billingAddressService.setByUserBilling(userPayment.getUserBilling(), billingAddress);
			}
		}
		
		model.addAttribute("shippingAddress", shippingAddress);
		model.addAttribute("payment", payment);
		model.addAttribute("billingAddress", billingAddress);
		model.addAttribute("cartItems", cartItems);
		model.addAttribute("shoppingCart", user.getShoppingCart());
		
		List<String> stateList = ITConstants.lisOfStatesCode;
		Collections.sort(stateList);
		model.addAttribute("stateList", stateList);
		model.addAttribute("classActiveShipping", true);
		
		if(missingRequiredField) {
			model.addAttribute("missingRequiredField", true);
		}
		
		return "checkout";
	}
}
