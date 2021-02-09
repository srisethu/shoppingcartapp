/**
 * 
 */
package com.mindtree.shoppingcart.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mindtree.shoppingcart.model.CartItem;
import com.mindtree.shoppingcart.model.User;
import com.mindtree.shoppingcart.model.UserCart;

/**
 * The interface Cart manager dao.
 *
 * @author M1017036
 */
@Repository
public interface CartManagerDao {

	/**
	 * Create user cart user cart.
	 *
	 * @param userCart the user cart
	 * @return user cart
	 */
	UserCart createUserCart(UserCart userCart);

	/**
	 * Retrive user cart user cart.
	 *
	 * @param user the user
	 * @return user cart
	 */
	UserCart retriveUserCart(User user);

	/**
	 * Retrive user cart by id optional.
	 *
	 * @param userCart the user cart
	 * @return optional
	 */
	Optional<UserCart> retriveUserCartById(UserCart userCart);

	/**
	 * Add cart item cart item.
	 *
	 * @param item the item
	 * @return cart item
	 */
	CartItem addCartItem(CartItem item);

}
