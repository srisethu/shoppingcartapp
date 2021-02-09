/**
 * 
 */
package com.mindtree.shoppingcart.dao;

import com.mindtree.shoppingcart.model.User;

/**
 * The interface User manager dao.
 *
 * @author M1017036
 */
public interface UserManagerDao {
	/**
	 * Gets user.
	 *
	 * @param user the user
	 * @return user
	 */
	public User getUser(User user);

	/**
	 * Save user user.
	 *
	 * @param user the user
	 * @return user
	 */
	public User saveUser(User user);
}
