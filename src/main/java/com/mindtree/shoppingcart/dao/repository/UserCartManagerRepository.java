/**
 * 
 */
package com.mindtree.shoppingcart.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.shoppingcart.model.User;
import com.mindtree.shoppingcart.model.UserCart;

/**
 * @author M1017036
 *
 */
public interface UserCartManagerRepository extends JpaRepository<UserCart, Integer>{

	/**
	 * @param user
	 * @return
	 */
	UserCart findByUser(User user);

	
}
