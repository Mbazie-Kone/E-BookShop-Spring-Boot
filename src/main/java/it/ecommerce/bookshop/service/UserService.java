package it.ecommerce.bookshop.service;

import java.util.Set;

import it.ecommerce.bookshop.model.User;
import it.ecommerce.bookshop.model.UserBilling;
import it.ecommerce.bookshop.model.UserPayment;
import it.ecommerce.bookshop.model.UserShipping;
import it.ecommerce.bookshop.model.security.PasswordResetToken;
import it.ecommerce.bookshop.model.security.UserRole;

public interface UserService {
	
	public PasswordResetToken gePasswordResetToken(final String token);
	
	public void creatPasswordResetTokenForUser(final User user, final String token);
	
	public User findByUsername(String username);
	
	public User findByEmail(String mail);
	
	public User findById(Long id);
	
	public User addUser(User user, Set<UserRole> userRoles) throws Exception;
	
	public User save(User user);
	
	public void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);
	
	public void updatUserShipping(UserShipping userShipping, User user);
	
	public void setUserDefaultPayment(Long userPaymentId, User user);
	
	public void setUserDefaultShipping(Long userShippingid, User user);

}