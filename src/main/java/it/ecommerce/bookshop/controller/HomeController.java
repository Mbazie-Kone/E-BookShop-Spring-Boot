package it.ecommerce.bookshop.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.ecommerce.bookshop.model.Book;
import it.ecommerce.bookshop.model.User;
import it.ecommerce.bookshop.service.BookService;
import it.ecommerce.bookshop.service.CartItemService;
import it.ecommerce.bookshop.service.OrderService;
import it.ecommerce.bookshop.service.UserPaymentService;
import it.ecommerce.bookshop.service.UserService;
import it.ecommerce.bookshop.service.UserShippingService;
import it.ecommerce.bookshop.service.impl.UserSecurityService;
import it.ecommerce.bookshop.utility.MailConstructor;

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
}
