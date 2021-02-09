/**
 * 
 */
package com.mindtree.shoppingcart.service;

import java.util.List;
import java.util.Map;

import com.mindtree.shoppingcart.model.CartItem;
import com.mindtree.shoppingcart.model.User;
import com.mindtree.shoppingcart.model.UserCart;

/**
 * @author M1017036
 *
 */
public interface CartManagerService {

	/**
	 * @param user
	 * @return
	 */
	UserCart createUserCart(User user);

	/**
	 * @param cartDetail
	 * @param userCart
	 */
	void addToCartDetails(CartItem cartDetail, UserCart userCart);

	/**
	 * @param loggedInUser
	 * @return
	 */
	Map<String, List<CartItem>> fetchCartItems(User loggedInUser);

	/**
	 * @param cartDetail
	 * @param userCart
	 */
	void updateCartDetails(CartItem cartDetail, UserCart userCart);

}
