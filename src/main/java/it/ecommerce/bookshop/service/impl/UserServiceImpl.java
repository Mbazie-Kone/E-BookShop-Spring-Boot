package it.ecommerce.bookshop.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import it.ecommerce.bookshop.model.User;
import it.ecommerce.bookshop.model.UserBilling;
import it.ecommerce.bookshop.model.UserPayment;
import it.ecommerce.bookshop.model.UserShipping;
import it.ecommerce.bookshop.model.security.PasswordResetToken;
import it.ecommerce.bookshop.model.security.UserRole;
import it.ecommerce.bookshop.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public PasswordResetToken gePasswordResetToken(String token) {
		
		
		
		return null;
	}

	@Override
	public void creatPasswordResetTokenForUser(User user, String token) {
		

	}

	@Override
	public User findByUsername(String username) {
		
		
		
		return null;
	}

	@Override
	public User findByEmail(String mail) {
		
		
		return null;
	}

	@Override
	public User findById(Long id) {
		
		
		
		return null;
	}

	@Override
	public User addUser(User user, Set<UserRole> userRoles) throws Exception {
		
		
		
		return null;
	}

	@Override
	public User update(User user) {
		
		
		
		return null;
	}

	@Override
	public void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user) {
		

	}

	@Override
	public void updatUserShipping(UserShipping userShipping, User user) {
		

	}

	@Override
	public void setUserDefaultPayment(Long userPaymentId, User user) {
		

	}

	@Override
	public void setUserDefaultShipping(Long userShippingid, User user) {
		

	}
}