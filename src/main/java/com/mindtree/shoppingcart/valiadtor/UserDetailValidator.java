/**
 * 
 */
package com.mindtree.shoppingcart.valiadtor;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mindtree.shoppingcart.model.User;

/**
 * @author M1017036
 *
 */
@Component
public class UserDetailValidator implements Validator {

	/**
	 * supports
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(User.class);
	}

	/**
	 * validate
	 */
	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if (!user.getPassword().matches("^[A-Za-z0-9_@./#&+-]*$")) {
			errors.rejectValue("password", "",
					"Minimum eight characters, at least one uppercase letter, one lowercase letter and one number required");
		}
		if (!user.getUsername().matches("^[A-Za-z0-9]*$")) {
			errors.rejectValue("username", "", "Minimum eight characters, at least one letter and one number required");
		}
	}

}
