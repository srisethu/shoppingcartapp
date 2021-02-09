/**
 * 
 */
package com.mindtree.shoppingcart.dao;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mindtree.shoppingcart.dao.repository.CartItemManagerRepository;
import com.mindtree.shoppingcart.dao.repository.UserCartManagerRepository;
import com.mindtree.shoppingcart.model.CartItem;
import com.mindtree.shoppingcart.model.User;
import com.mindtree.shoppingcart.model.UserCart;

/**
 * The type Cart manager dao.
 *
 * @author M1017036
 */
@Repository
public class CartManagerDaoImpl implements CartManagerDao {

	/**
	 * userCartRepo
	 */
	@Resource
	UserCartManagerRepository userCartRepo;

	/**
	 * cartItemRepo
	 */
	@Resource
	CartItemManagerRepository cartItemRepo;

	/**
	 * Create user cart user cart.
	 *
	 * @param userCart the user cart
	 * @return the user cart
	 */
	@Override
	public UserCart createUserCart(UserCart userCart) {
		return userCartRepo.save(userCart);
	}

	/**
	 * Retrive user cart user cart.
	 *
	 * @param user the user
	 * @return the user cart
	 */
	@Override
	public UserCart retriveUserCart(User user) {
		return userCartRepo.findByUser(user);
	}

	/**
	 * retriveUserCartById
	 *
	 * @param userCart the user cart
	 * @return the optional
	 */
	@Override
	public Optional<UserCart> retriveUserCartById(UserCart userCart) {
		return userCartRepo.findById(userCart.getCartId());
	}

	/**
	 * addCartItem
	 *
	 * @param item the item
	 * @return the cart item
	 */
	@Override
	public CartItem addCartItem(CartItem item) {
		return cartItemRepo.save(item);
	}

}
