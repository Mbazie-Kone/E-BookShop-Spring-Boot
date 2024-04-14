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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creatPasswordResetTokenForUser(User user, String token) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByEmail(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addUser(User user, Set<UserRole> userRoles) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatUserShipping(UserShipping userShipping, User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUserDefaultPayment(Long userPaymentId, User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUserDefaultShipping(Long userShippingid, User user) {
		// TODO Auto-generated method stub

	}

}
