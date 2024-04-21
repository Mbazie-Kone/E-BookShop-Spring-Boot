package it.ecommerce.bookshop.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.ecommerce.bookshop.model.Book;
import it.ecommerce.bookshop.model.User;
import it.ecommerce.bookshop.model.UserBilling;
import it.ecommerce.bookshop.model.UserPayment;
import it.ecommerce.bookshop.model.UserShipping;
import it.ecommerce.bookshop.service.BookService;
import it.ecommerce.bookshop.service.CartItemService;
import it.ecommerce.bookshop.service.OrderService;
import it.ecommerce.bookshop.service.UserPaymentService;
import it.ecommerce.bookshop.service.UserService;
import it.ecommerce.bookshop.service.UserShippingService;
import it.ecommerce.bookshop.service.impl.UserSecurityService;
import it.ecommerce.bookshop.utility.ITConstants;
import it.ecommerce.bookshop.utility.MailConstructor;
import it.ecommerce.bookshop.utility.SecurityUtility;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;

@Controller
public class HomeController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private MailConstructor mailConstructor;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserSecurityService userSecurityService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserPaymentService userPaymentService;
	
	@Autowired
	private UserShippingService userShippingService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/")
	public String index() {
		
		return "index";		
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		
		model.addAttribute("classActiveLogin", true);
		
		return "myAccount";		
	}
	
	@GetMapping("/faq")
	public String faq() {
		
		return "faq";	
	}
	
	@GetMapping("/bookshelf")
	public String bookshelf(Model model, Principal principal) {
		
		if(principal != null) {
			String userName = principal.getName();
			User user = userService.findByUsername(userName);
			model.addAttribute("user", user);
		}
		
		List<Book> books = bookService.findAll();
		
		model.addAttribute("books", books);
		model.addAttribute("activeAll", true);
		
		return "bookshelf";
	}
	
	@GetMapping("/bookDetail")
	public String bookDetail(@PathParam("id") Long id, Model model, Principal principal) {
		
		if(principal != null) {
			String userName = principal.getName();
			User user = userService.findByUsername(userName);
			model.addAttribute("user", user);
		}
		
		Book book = bookService.findById(id);
		
		model.addAttribute("book", book);
		
		List<Integer> qtyList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		model.addAttribute("qtyList", qtyList);
		model.addAttribute("qty", 1);
		
		return "bookDetail";
	}
	
	@GetMapping("/forgetPassword")
	public String forgetPassword(HttpServletRequest request, @ModelAttribute("email") String email, Model model) {
		
		model.addAttribute("classActiveForgetPassword", true);
		
		User user = userService.findByEmail(email);
		
		if(user == null) {
			model.addAttribute("emailNotExist", true);
			
			return "myAccount";
		}
		
		String password = SecurityUtility.randomPassword();
		String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
		
		user.setPassWord(encryptedPassword);
		
		userService.save(user);
		
		String token = UUID.randomUUID().toString();
		
		userService.creatPasswordResetTokenForUser(user, token);
		
		String appUrl = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		
		SimpleMailMessage newEmail = mailConstructor.constructResetTokenEmail(appUrl, request.getLocale(), token, user, password);
		
		mailSender.send(newEmail);
		
		model.addAttribute("forgetPasswordEmailSent", true);
		
		return "myAccount";	
	}
	
	@GetMapping("/myProfile")
	public String myProfile(Model model, Principal principal) {
		
		User user = userService.findByUsername(principal.getName());
		
		model.addAttribute("user", user);
		model.addAttribute("userPayments", user.getUserPayments());
		model.addAttribute("userShippings", user.getUserShippings());
		model.addAttribute("userOrders", user.getOrders());
		
		UserShipping userShipping = new UserShipping();
		model.addAttribute("userShipping", userShipping);
		
		model.addAttribute("listOfCreditCards", true);
		model.addAttribute("listOfShippingAddresses", true);
		
		List<String> stateList = ITConstants.lisOfStatesCode;
		Collections.sort(stateList);
		
		model.addAttribute("statelist", stateList);
		model.addAttribute("classActiveEdit", true);
		
		return "myProfile";
	}
	
	@GetMapping("/listOfCreditCards")
	public String listOfCreditCards(Model model, Principal principal, HttpServletRequest request) {
		
		User user = userService.findByUsername(principal.getName());
		
		model.addAttribute("user", user);
		model.addAttribute("userPayments", user.getUserPayments());
		model.addAttribute("userShippings", user.getUserShippings());
		model.addAttribute("userOrders", user.getOrders());
		
		model.addAttribute("listOfCreditCards", true);
		model.addAttribute("classActiveBilling", true);
		model.addAttribute("listOfShippingAddresses", true);
		
		return "myProfile";	
	}
	
	@GetMapping("/listOfShippingAddresses")
	public String listOfShippingAddresses(Model model, Principal principal, HttpServletRequest request) {
		
		User user = userService.findByUsername(principal.getName());
		
		model.addAttribute("user", user);
		model.addAttribute("userPayments", user.getUserPayments());
		model.addAttribute("userShippings", user.getUserShippings());
		model.addAttribute("userOrders", user.getOrders());
		
		model.addAttribute("listOfCreditCards", true);
		model.addAttribute("classActiveBilling", true);
		model.addAttribute("listOfShippingAddresses", true);
		
		return "myProfile";	
	}
	
	@GetMapping("/addNewCreditCard")
	public String addNewCreditCard(Model model, Principal principal) {
		
		User user = userService.findByUsername(principal.getName());
		
		model.addAttribute("user", user);
		model.addAttribute("addNewCreditCard", true);
		model.addAttribute("classActiveBilling", true);
		model.addAttribute("listOfShippingAddresses", true);
		
		UserBilling userBilling = new UserBilling();
		
		UserPayment userPayment = new UserPayment();
		
		model.addAttribute("userBilling", userBilling);
		model.addAttribute("userPayment", userPayment);
		
		List<String> stateList = ITConstants.lisOfStatesCode;
		Collections.sort(stateList);
		
		model.addAttribute("stateList", stateList);
		model.addAttribute("userPayments", user.getUserPayments());
		model.addAttribute("userShippings", user.getUserShippings());
		model.addAttribute("orderList", user.getOrders());
		
		return "myProfile";
	}
	
	@GetMapping("/addNewShippingAddresses")
	public String addNewShippingAddresses(Model model, Principal principal) {
		
		User user = userService.findByUsername(principal.getName());
		
		model.addAttribute("user", user);
		model.addAttribute("addNewShippingAddress", true);
		model.addAttribute("classActiveBilling", true);
		model.addAttribute("listOfCreditCards", true);
		
		UserShipping userShipping = new UserShipping();
		
		model.addAttribute("userShipping", userShipping);
		
		List<String> stateList = ITConstants.lisOfStatesCode;
		Collections.sort(stateList);
		
		model.addAttribute("stateList", stateList);
		model.addAttribute("userPayments", user.getUserPayments());
		model.addAttribute("userShippings", user.getUserShippings());
		model.addAttribute("orderList", user.getOrders());
		
		return "myProfile";
	}
	
	@PostMapping("/addNewCreditCard")
	public String addNewCreditCard(@ModelAttribute("userPayment") UserPayment userPayment, 
			@ModelAttribute("userBilling") UserBilling userBilling, Principal principal, Model model) {
		
		User user = userService.findByUsername(principal.getName());
		
		userService.updateUserBilling(userBilling, userPayment, user);
		
		model.addAttribute("user", user);
		model.addAttribute("userPayments", user.getUserPayments());
		model.addAttribute("userShippings", user.getUserShippings());
		model.addAttribute("listOfCreditCards", true);
		model.addAttribute("classActiveBilling", true);
		model.addAttribute("listOfShippingAddresses", true);
		model.addAttribute("orderList", user.getOrders());
		
		return "myProfile";
	}
	
	@PostMapping("/addNewShippingAddress")
	public String addNewShippingAddressPost(@ModelAttribute("userShipping") UserShipping userShipping, Principal principal, Model model) {
		
		User user = userService.findByUsername(principal.getName());
		
		userService.updateUserShipping(userShipping, user);
		
		model.addAttribute("user", user);
		model.addAttribute("userPayments", user.getUserPayments());
		model.addAttribute("userShippings", user.getUserShippings());
		model.addAttribute("listOfShippingAddresses", true);
		model.addAttribute("classActiveBilling", true);
		model.addAttribute("listOfCreditCards", true);
		model.addAttribute("orderList", user.getOrders());
		
		return "myProfile";
	}
	
	@GetMapping("/updateCreditCard")
	public String updateCreditCard(@ModelAttribute("id") Long creditCard, Principal principal, Model model) {
		
		User user = userService.findByUsername(principal.getName());
		
		UserPayment userPayment = userPaymentService.findById(creditCard);
		
		if(user.getId() != userPayment.getUser().getId()) {
			
			return "badRequestPage";
		}
		else {
			model.addAttribute("user", user);
			
			UserBilling userBilling = userPayment.getUserBilling();
			
			model.addAttribute("userPayment", userPayment);
			model.addAttribute("userBilling", userBilling);
			
			List<String> stateList = ITConstants.lisOfStatesCode;
			Collections.sort(stateList);
			
			model.addAttribute("stateList", stateList);
			model.addAttribute("addNewCreditCard", true);
			model.addAttribute("classActiveBilling", true);
			model.addAttribute("listOfShippingAddresses", true);
			model.addAttribute("userPayments", user.getUserPayments());
			model.addAttribute("userShippings", user.getUserShippings());
			model.addAttribute("orderList", user.getOrders());
			
			return "myProfile";
		}		
	}
} 
