package it.ecommerce.bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ecommerce.bookshop.model.ShoppingCart;
import it.ecommerce.bookshop.model.User;
import it.ecommerce.bookshop.model.UserBilling;
import it.ecommerce.bookshop.model.UserPayment;
import it.ecommerce.bookshop.model.UserShipping;
import it.ecommerce.bookshop.model.security.PasswordResetToken;
import it.ecommerce.bookshop.model.security.UserRole;
import it.ecommerce.bookshop.repository.PasswordResetTokenRepository;
import it.ecommerce.bookshop.repository.RoleRepository;
import it.ecommerce.bookshop.repository.UserPaymentRepository;
import it.ecommerce.bookshop.repository.UserRepository;
import it.ecommerce.bookshop.repository.UserShippingRepository;
import it.ecommerce.bookshop.service.UserService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserPaymentRepository userPaymentRepository;
	
	@Autowired
	private UserShippingRepository userShippingRepository;
	
	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;

	@Override
	public PasswordResetToken gePasswordResetToken(String token) {
		
		return passwordResetTokenRepository.findByToken(token);
	}

	@Override
	public void creatPasswordResetTokenForUser(User user, String token) {
		
		final PasswordResetToken myToken = new PasswordResetToken(token, user);
		passwordResetTokenRepository.save(myToken);
	}

	@Override
	public User findByUsername(String username) {

		return userRepository.findByUserName(username);
	}

	@Override
	public User findByEmail(String mail) {
		
		return userRepository.findByEmail(mail);
	}

	@Override
	public User findById(Long id) {
		
		return userRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public User addUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User localUser = userRepository.findByUserName(user.getUserName());
		
		if(localUser != null) {
			LOG.info("user {} already exists. Nothing will be done.", user.getUsername());
		}
		else {
			for (UserRole userRole : userRoles) {
				roleRepository.save(userRole.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			
			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.setUser(user);
			user.setShoppingCart(shoppingCart);
			user.setUserShippings(new ArrayList<>());
			user.setUserPayments(new ArrayList<>());
			
			localUser = userRepository.save(user);
		}
		
		return localUser;
	}

	@Override
	public User save(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user) {
		
		userPayment.setUser(user);
		userPayment.setUserBilling(userBilling);
		userPayment.setDefaultPayment(true);
		userBilling.setUserPayment(userPayment);
		user.getUserPayments().add(userPayment);
		
		save(user);

	}

	@Override
	public void updatUserShipping(UserShipping userShipping, User user) {
		
		userShipping.setUser(user);
		userShipping.setUserShippingDefault(true);
		user.getUserShippings().add(userShipping);
		
		save(user);
	}

	@Override
	public void setUserDefaultPayment(Long userPaymentId, User user) {
		
		List<UserPayment> userPayments = (List<UserPayment>) userPaymentRepository.findAll();
		
		for (UserPayment userPayment : userPayments) {
			if(userPayment.getId() == userPaymentId) {
				userPayment.setDefaultPayment(true);
				userPaymentRepository.save(userPayment);
			}
			else {
				userPayment.setDefaultPayment(false);
				userPaymentRepository.save(userPayment);
			}
		}
	}

	@Override
	public void setUserDefaultShipping(Long userShippingid, User user) {
		
		List<UserShipping> userShippings = (List<UserShipping>) userShippingRepository.findAll();
		
		for (UserShipping userShipping : userShippings) {
			if(userShipping.getId() == userShippingid) {
				userShipping.setUserShippingDefault(true);
				userShippingRepository.save(userShipping);
			}
			else {
				userShipping.setUserShippingDefault(false);
				userShippingRepository.save(userShipping);
			}
		}
	}
}