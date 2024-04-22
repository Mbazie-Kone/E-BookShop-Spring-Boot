package it.ecommerce.bookshop.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.ecommerce.bookshop.model.Book;
import it.ecommerce.bookshop.model.CartItem;
import it.ecommerce.bookshop.model.Order;
import it.ecommerce.bookshop.model.User;
import it.ecommerce.bookshop.model.UserBilling;
import it.ecommerce.bookshop.model.UserPayment;
import it.ecommerce.bookshop.model.UserShipping;
import it.ecommerce.bookshop.model.security.PasswordResetToken;
import it.ecommerce.bookshop.model.security.Role;
import it.ecommerce.bookshop.model.security.UserRole;
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
		model.addAttribute("classActiveShipping", true);
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
		model.addAttribute("classActiveShipping", true);
		model.addAttribute("listOfCreditCards", true);
		model.addAttribute("orderList", user.getOrders());
		
		return "myProfile";
	}
	
	@GetMapping("/updateCreditCard")
	public String updateCreditCard(@ModelAttribute("id") Long creditCard, Principal principal, Model model) {
		
		User user = userService.findByUsername(principal.getName());
		
		UserPayment userPayment = userPaymentService.findById(creditCard);
		
		if(user.getId()!= userPayment.getUser().getId()) {
			
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
	
	@GetMapping("/updateUserShipping")
	public String updateUserShipping(@ModelAttribute("id") Long shippingAddressId, Principal principal, Model model) {
		
		User user = userService.findByUsername(principal.getName());
		
		UserShipping userShipping = userShippingService.findById(shippingAddressId);
		
		if(user.getId()!= userShipping.getUser().getId()) {
			
			return "badRequestPage";
		}
		else {
			model.addAttribute("user", user);	
			model.addAttribute("userShipping", userShipping);
			
			List<String> stateList = ITConstants.lisOfStatesCode;
			Collections.sort(stateList);
			
			model.addAttribute("stateList", stateList);
			model.addAttribute("addNewShippingAddress", true);
			model.addAttribute("classActiveShipping", true);
			model.addAttribute("listOfCreditCards", true);
			model.addAttribute("userPayments", user.getUserPayments());
			model.addAttribute("userShippings", user.getUserShippings());
			model.addAttribute("orderList", user.getOrders());
			
			return "myProfile";
		}	
	}
	
	@PostMapping("/setDefaultPayment")
	public String setDefaultPayment(@ModelAttribute("defaultUserPaymentId") Long defaultUserPaymentId, Principal principal, Model model) {
		
		User user = userService.findByUsername(principal.getName());
		
		userService.setUserDefaultPayment(defaultUserPaymentId, user);
		
		model.addAttribute("user", user);
		model.addAttribute("listOfCreditCards", true);
		model.addAttribute("classActiveBilling", true);
		model.addAttribute("listOfShippingAddresses", true);	
		model.addAttribute("userPayments", user.getUserPayments());
		model.addAttribute("userShippings", user.getUserShippings());
		model.addAttribute("orderList", user.getOrders());
		
		return "myProfile";	
	}
	
	@PostMapping("/setDefaultShippingAddress")
	public String setDefaultShippingAddress(@ModelAttribute("defaultShippingAddressId") Long defaultShippingId, Principal principal, Model model) {
		
		User user = userService.findByUsername(principal.getName());
		
		userService.setUserDefaultShipping(defaultShippingId, user);
		
		model.addAttribute("user", user);
		model.addAttribute("listOfCreditCards", true);
		model.addAttribute("classActiveShipping", true);
		model.addAttribute("listOfShippingAddresses", true);	
		model.addAttribute("userPayments", user.getUserPayments());
		model.addAttribute("userShippings", user.getUserShippings());
		model.addAttribute("orderList", user.getOrders());
		
		return "myProfile";
	}
	
	@GetMapping("/removeCreditCard")
	public String removeCreditCard(@ModelAttribute("id") Long creditCardId, Principal principal, Model model) {
		
		User user = userService.findByUsername(principal.getName());
		
		UserPayment userPayment = userPaymentService.findById(creditCardId);
		
		if(user.getId()!= userPayment.getUser().getId()) {
			
			return "badRequestPage";
		}
		else {
			model.addAttribute("user", user);
			
			userPaymentService.deleteById(creditCardId);
			
			model.addAttribute("listOfCreditCards", true);
			model.addAttribute("classActiveBilling", true);
			model.addAttribute("listOfShippingAddresses", true);
			model.addAttribute("userPayments", user.getUserPayments());
			model.addAttribute("userShippings", user.getUserShippings());
			model.addAttribute("orderList", user.getOrders());
			
			return "myProfile";
		}	
	}
	
	@GetMapping("/removeUserShipping")
	public String removeUserShipping(@ModelAttribute("id") Long userShippingId, Principal principal, Model model) {
		
		User user = userService.findByUsername(principal.getName());
		
		UserShipping userShipping = userShippingService.findById(userShippingId);
		
		if(user.getId()!= userShipping.getUser().getId()) {
			
			return "badRequestPage";
		}
		else {
			model.addAttribute("user", user);
			
			userShippingService.deleteById(userShippingId);
			
			model.addAttribute("listOfShippingAddresses", true);
			model.addAttribute("classActiveShipping", true);
			model.addAttribute("userPayments", user.getUserPayments());
			model.addAttribute("userShippings", user.getUserShippings());
			model.addAttribute("orderList", user.getOrders());
			
			return "myProfile";
		}	
	}
	
	@PostMapping("/newUser")
	public String newUserPost(HttpServletRequest request, @ModelAttribute("userEmail") String userEmail, 
			@ModelAttribute("username") String username, Model model) throws Exception {
		
		model.addAttribute("classActiveNewAccount", true);
		model.addAttribute("userEmail", userEmail);
		model.addAttribute("username", username);
		
		if(userService.findByUsername(username) != null ) {
			model.addAttribute("usernameExists", true);
			
			return "myAccount";
		}
		
		if(userService.findByEmail(userEmail) != null) {
			model.addAttribute("emailExists", true);
			
			return "myAccount";
		}
		
		User user = new User();
		user.setUserName(username);
		user.setEmail(userEmail);
		
		String password = SecurityUtility.randomPassword();
		
		String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
		
		user.setPassWord(encryptedPassword);
		
		Role role = new Role();
		role.setId(1);
		role.setName("ROLE_USER");
		
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(role, user));
		
		userService.addUser(user, userRoles);
		
		String token = UUID.randomUUID().toString();
		
		userService.creatPasswordResetTokenForUser(user, token);
		
		String appUrl = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		
		SimpleMailMessage email = mailConstructor.constructResetTokenEmail(appUrl, request.getLocale(), token, user, password);
		
		mailSender.send(email);
		
		model.addAttribute("emailSent", "true");
		model.addAttribute("orderList", user.getOrders());
		
		return "myAccount";
	}
	
	@GetMapping("/newUser")
	public String newUser(Locale locale, @RequestParam("token") String token, Model model) {
		
		PasswordResetToken passToken = userService.gePasswordResetToken(token);
		
		if(passToken == null) {
			String message = "Invalid token";
			model.addAttribute("message", message);
			
			return "redirect:/badRequest";
		}
		
		User user = passToken.getUser();
		
		String username = user.getUsername();
		
		UserDetails userDetails = userSecurityService.loadUserByUsername(username);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		model.addAttribute("user", user);
		model.addAttribute("classActiveEdit", true);
		model.addAttribute("orderList", user.getOrders());
		
		return "myProfile";
	}
	
	@PostMapping("/updateUserInfo")
	public String updateUserInfo(@ModelAttribute("user") User user, @ModelAttribute("newPassword") String newPassword, Model model) throws Exception{
		
		User currentUser = userService.findById(user.getId());
		
		if(currentUser == null) {
			throw new Exception("User not found");
		}
		
		// Check email already exists
		if(userService.findByEmail(user.getEmail()) != null) {
			if(userService.findByEmail(user.getEmail()).getId() != currentUser.getId()) {
				model.addAttribute("emailExists", true);
				
				return "myProfile";
			}
		}
		
		// Check username already exists
		if(userService.findByUsername(user.getUsername()) != null) {
			if(userService.findByUsername(user.getUsername()).getId() != currentUser.getId()) {
				model.addAttribute("usernameExists", true);
				
				return "myProfile";
			}
		}
		
		// Update password
		if(newPassword != null && !newPassword.isEmpty() && !newPassword.equals("")) {
			BCryptPasswordEncoder passwordEncoder = SecurityUtility.passwordEncoder();
			String dbPassword = currentUser.getPassword();
			
			if(passwordEncoder.matches(user.getPassword(), dbPassword)) {
				currentUser.setPassWord(passwordEncoder.encode(newPassword));
			}
			else {
				model.addAttribute("incorrectPassword", true);
				
				return "myProfile";
			}
		}
		
		currentUser.setFistName(user.getFistName());
		currentUser.setLastName(user.getLastName());
		currentUser.setUserName(user.getUserName());
		currentUser.setEmail(user.getEmail());
		
		userService.save(currentUser);
		
		model.addAttribute("updateSuccess", true);
		model.addAttribute("user", currentUser);
		model.addAttribute("classActiveEdit", true);
		
		UserDetails userDetails = userSecurityService.loadUserByUsername(currentUser.getUsername());
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		model.addAttribute("orderList", user.getOrders());
		
		return "myProfile";	
	}
	
	@GetMapping("/orderDetail")
	public String orderDetail(@RequestParam("id") Long orderId, Principal principal, Model model) {
		
		User user = userService.findByUsername(principal.getName());
		
		Order order = orderService.findOrderById(orderId);
		
		if(order.getUser().getId() != user.getId()) {
			
			return "badRequestPage";
		}
		else {
			List<CartItem> cartItems = cartItemService.findByOrder(order);
			
			model.addAttribute("cartItems", cartItems);
			model.addAttribute("user", user);
			model.addAttribute("order", order);
			model.addAttribute("userPayments", user.getUserPayments());
			model.addAttribute("userShippings", user.getUserShippings());
			model.addAttribute("orderList", user.getOrders());
			
			UserShipping userShipping = new UserShipping();
			
			model.addAttribute("userShipping", userShipping);
			
			List<String> stateList = ITConstants.lisOfStatesCode;
			Collections.sort(stateList);
			
			model.addAttribute("stateList", stateList);
			model.addAttribute("listOfShippingAddresses", true);
			model.addAttribute("classActiveOrders", true);
			model.addAttribute("listOfCreditCards", true);
			model.addAttribute("displayOrderDetail", true);
			
			return "myProfile";	
		}	
	}
}