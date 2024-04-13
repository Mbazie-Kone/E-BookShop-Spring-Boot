package it.ecommerce.bookshop.utility;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import it.ecommerce.bookshop.model.Order;
import it.ecommerce.bookshop.model.User;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Component
public class MailConstructor {
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private Environment env;
	
	public SimpleMailMessage constructResetTokenEmail(String contextPath, Locale locale, String token, User user, String password) {
		
		String url = contextPath + "/newUser?token"+token;
		String message = "\nPlease click on this link to verify your email and edit your persoanl information. Your password is: \n"+password;
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setSubject("E-BookShop new user");
		mail.setText(url+message);
		mail.setFrom(env.getProperty("support.email"));
		
		return mail;		
	}
	
	public MimeMessagePreparator constructOrderConfirmationEmail(User user, Order order, Locale locale) {
		
		Context context = new Context();
		context.setVariable("order", order);
		context.setVariable("user", user);
		context.setVariable("CartItems", order.getCartItems());
		String text = templateEngine.process("orderConfirmationEmailTemplate", context);
		
		MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				
				MimeMessageHelper email = new MimeMessageHelper(mimeMessage);
				email.setTo(user.getEmail());
				email.setSubject("Order confirmation - "+order.getId());
				email.setText(text, true);
				email.setFrom(new InternetAddress("mbazie.ebookshop@gmail.com"));
			}
		};
		
		return messagePreparator;
	}
}
