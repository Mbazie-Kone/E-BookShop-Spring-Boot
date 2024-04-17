package it.ecommerce.bookshop.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.ecommerce.bookshop.model.BillingAddress;
import it.ecommerce.bookshop.model.CartItem;
import it.ecommerce.bookshop.model.Order;
import it.ecommerce.bookshop.model.Payment;
import it.ecommerce.bookshop.model.ShippingAddress;
import it.ecommerce.bookshop.model.ShoppingCart;
import it.ecommerce.bookshop.model.User;
import it.ecommerce.bookshop.model.UserBilling;
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
		
		user.getShoppingCart();
		
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
	
	@PostMapping("/checkout")
	public String checkoutPost(@ModelAttribute("shippingAddress") ShippingAddress shippingAddress, 
			@ModelAttribute("billingAddress") BillingAddress billingAddress, @ModelAttribute("payment") Payment payment, 
			@ModelAttribute("billingSameAsShipping") String billingSameAsShipping, @ModelAttribute("shippingMethod") String shippingMethod, 
			Principal principal, Model model) {
		
		ShoppingCart shoppingCart = userService.findByUsername(principal.getName()).getShoppingCart();
		
		List<CartItem> cartItems = cartItemService.findByShoppingCart(shoppingCart);
		
		model.addAttribute("cartItems", cartItems);
		
		if(billingSameAsShipping.equals("true")) {
			billingAddress.setAddressName(shippingAddress.getShippingAddressName());
			billingAddress.setStreet1(shippingAddress.getShippingAddressStreet1());
			billingAddress.setStreet2(shippingAddress.getShippingAddressStreet2());
			billingAddress.setCity(shippingAddress.getShippingAddressCity());
			billingAddress.setState(shippingAddress.getShippingAddressState());
			billingAddress.setCountry(shippingAddress.getShippingAddressCountry());
			billingAddress.setZipCode(shippingAddress.getShippingAddressZipCode());	
		}
		
		if(shippingAddress.getShippingAddressStreet1().isEmpty() || shippingAddress.getShippingAddressCity().isEmpty() 
				|| shippingAddress.getShippingAddressState().isEmpty()
				|| shippingAddress.getShippingAddressName().isEmpty()
				|| shippingAddress.getShippingAddressZipCode().isEmpty() || payment.getCardNumber().isEmpty()
				|| payment.getCvc() == 0 || billingAddress.getStreet1().isEmpty()
				|| billingAddress.getCity().isEmpty() || billingAddress.getState().isEmpty()
				|| billingAddress.getAddressName().isEmpty()
				|| billingAddress.getZipCode().isEmpty()) {
			
			return "redirect:/ckeckout?id" + shoppingCart.getId() + "&missingRequireField=true";
		}
		
		User user = userService.findByUsername(principal.getName());
			
		Order order = orderService.addOrder(shoppingCart, shippingAddress, billingAddress, payment, shippingMethod, user);
			
		mailSender.send(mailConstructor.constructOrderConfirmationEmail(user, order, Locale.ITALIAN));
			
		shoppingCartService.clearShoppingCart(shoppingCart);
			
		LocalDate today = LocalDate.now();
		LocalDate estimatedDeliveryDate;
			
		if(shippingMethod.equals("groungShipping")) {
			estimatedDeliveryDate = today.plusDays(5);
		}
		else {
			estimatedDeliveryDate = today.plusDays(3);
		}
		
		model.addAttribute("estimatedDeliveryDate", estimatedDeliveryDate);
		
		return "orderSubmittedPage";
	}
	
	@GetMapping("/setShippingAddress")
	public String setShippingAddress(@RequestParam("userShippingId") Long userShippingId, Principal principal, Model model) {
		
		User user = userService.findByUsername(principal.getName());
		
		UserShipping userShipping = userShippingService.findById(userShippingId);
		
		if(userShipping.getUser().getId() != user.getId()) {
			
			return "badRequestPage";
		}
		else {
			shippingAddressService.setByUserShipping(userShipping, shippingAddress);
			
			List<CartItem> cartItems = cartItemService.findByShoppingCart(user.getShoppingCart());
			
			model.addAttribute("shippingAddress", shippingAddress);
			model.addAttribute("payment", payment);
			model.addAttribute("billingAddress", billingAddress);
			model.addAttribute("cartItems", cartItems);
			model.addAttribute("shoppingCart", user.getShoppingCart());
			
			List<String> stateList = ITConstants.lisOfStatesCode;
			Collections.sort(stateList);
			
			model.addAttribute("stateList", stateList);
			
			List<UserShipping> userShippings = user.getUserShippings();
			List<UserPayment> userPayments = user.getUserPayments();
			
			model.addAttribute("userShippings", userShippings );
			model.addAttribute("userPayments", userPayments);
			model.addAttribute("shippingAddress", shippingAddress);
			model.addAttribute("classActiveShipping", true);
			
			if(userPayments.size() == 0) {
				model.addAttribute("emptyPayments", true);
			}
			else {
				model.addAttribute("emptyPayments", false);
			}
			
			model.addAttribute("emptyShippings", false);
			
			return "checkout";
		}	
	}
	
	@GetMapping("/setPaymentMethod")
	public String setPaymentMethod(@RequestParam("userPaymentId") Long userPaymentId, Principal principal, Model model) {
		
		User user = userService.findByUsername(principal.getName());
		
		UserPayment userPayment = userPaymentService.findById(userPaymentId);
		
		UserBilling userBilling = userPayment.getUserBilling();
		
		if(userPayment.getUser().getId() != user.getId()) {
			
			return"badRequestPage";
		}
		else {
			paymentService.setByUserPayment(userPayment, payment);
			
			List<CartItem> cartItems = cartItemService.findByShoppingCart(user.getShoppingCart());
			
			billingAddressService.setByUserBilling(userBilling, billingAddress);
			
			model.addAttribute("shippingAddress", shippingAddress);
			model.addAttribute("payment", payment);
			model.addAttribute("billingAddress", billingAddress);
			model.addAttribute("cartItems", cartItems);
			model.addAttribute("shoppingCart", user.getShoppingCart());
			
			List<String> stateList = ITConstants.lisOfStatesCode;
			Collections.sort(stateList);
			
			model.addAttribute("stateList", stateList);
			
			List<UserShipping> userShippings = user.getUserShippings();
			List<UserPayment> userPayments = user.getUserPayments();
			
			model.addAttribute("userShippings", userShippings);
			model.addAttribute("userPayments", userPayments);
			model.addAttribute("shippingAddress", shippingAddress);
			model.addAttribute("classActivePayment", true);
			model.addAttribute("emptyPaymentList", false);
			
			if(userShippings.size() == 0) {
				model.addAttribute("emptyShippingList", true);
			}
			else {
				model.addAttribute("emptyShippingList", false);
			}
		}
		
		return "checkout";	
	}
}