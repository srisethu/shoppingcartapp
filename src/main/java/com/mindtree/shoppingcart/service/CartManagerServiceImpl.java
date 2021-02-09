/**
 * 
 */
package com.mindtree.shoppingcart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.shoppingcart.dao.CartManagerDao;
import com.mindtree.shoppingcart.dao.ProductManagerDao;
import com.mindtree.shoppingcart.model.Apparel;
import com.mindtree.shoppingcart.model.Book;
import com.mindtree.shoppingcart.model.CartItem;
import com.mindtree.shoppingcart.model.Product;
import com.mindtree.shoppingcart.model.User;
import com.mindtree.shoppingcart.model.UserCart;

/**
 * @author M1017036
 *
 */
@Service
@Transactional( rollbackFor = DataAccessException.class)
public class CartManagerServiceImpl implements CartManagerService {
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CartManagerServiceImpl.class);

	/**
	 * cartManagerDao
	 */
	@Autowired
	private CartManagerDao cartManagerDao;

	/**
	 * productManagerDao
	 */
	@Autowired
	private ProductManagerDao productManagerDao;

	/**
	 *createUserCart
	 */
	@Override
	public UserCart createUserCart(User user) {
		UserCart userCart = cartManagerDao.retriveUserCart(user);
		if (userCart == null) {
			LOGGER.info("new cart details");
			userCart = new UserCart();
			userCart.setUser(user);
			return cartManagerDao.createUserCart(userCart);
		}
		return userCart;
	}

	/**
	 * addToCartDetails
	 */
	@Override
	public void addToCartDetails(CartItem cartItem, UserCart userCart) {
		Product product = productManagerDao.fetchProductById(cartItem.getProduct().getProductId()).get(0);
		userCart = cartManagerDao.retriveUserCartById(userCart).get();
		if (userCart.getCartItems() == null) {
			LOGGER.info("adding new item to cart");
			Set<CartItem> cartItems = new HashSet<CartItem>();
			userCart.setCartItems(cartItems);
			addNewProductToCart(cartItem, product, cartItems);
			cartManagerDao.createUserCart(userCart);
		} else {
			LOGGER.info("updating product quantity");
			Integer quantity = cartItem.getQuantity();
			boolean productExist = false;
			for (CartItem item : userCart.getCartItems()) {
				if (item.getProduct().getProductId() == cartItem.getProduct().getProductId()) {
					item.setQuantity(item.getQuantity() + quantity);
					cartManagerDao.addCartItem(item);
					productExist = true;
					break;
				}
			}
			if (!productExist) {
				addNewProductToCart(cartItem, product, userCart.getCartItems());
				cartManagerDao.createUserCart(userCart);
			}
		}
	}

	/**
	 * @param cartItem
	 * @param product
	 * @param cartItems
	 */
	private void addNewProductToCart(CartItem cartItem, Product product, Set<CartItem> cartItems) {
		CartItem item = new CartItem();
		item.setProduct(product);
		item.setQuantity(cartItem.getQuantity());
		item = cartManagerDao.addCartItem(item);
		cartItems.add(item);
	}

	/**
	 *fetchCartItems
	 */
	@Override
	public Map<String, List<CartItem>> fetchCartItems(User loggedInUser) {
		Map<String, List<CartItem>> cartItemsMap = new HashMap<String, List<CartItem>>();
		UserCart userCart = cartManagerDao.retriveUserCart(loggedInUser);
		if (userCart != null) {
			Set<CartItem> cartItems = userCart.getCartItems();
			for (CartItem cartItem : cartItems) {
				String productType = null;
				if (cartItem.getProduct() instanceof Book) {
					productType = "BOOK";
				} else if (cartItem.getProduct() instanceof Apparel) {
					productType = "APPAREL";
				}
				if (productType != null) {
					List<CartItem> CartItemList = null;
					if (cartItemsMap.get(productType) != null) {
						CartItemList = cartItemsMap.get(productType);
					} else {
						CartItemList = new ArrayList<CartItem>();
						cartItemsMap.put(productType, CartItemList);
					}
					CartItemList.add(cartItem);
				}
			}
		}
		return cartItemsMap;
	}

	/**
	 * updateCartDetails
	 */
	@Override
	public void updateCartDetails(CartItem cartItem, UserCart userCart) {
		userCart = cartManagerDao.retriveUserCartById(userCart).get();
		if (cartItem.getQuantity() == 0) {
			LOGGER.info("removing product from cart");
			for (CartItem item : userCart.getCartItems()) {
				if (item.getProduct().getProductId() == cartItem.getProduct().getProductId()) {
					userCart.getCartItems().remove(item);
					break;
				}
			}
			cartManagerDao.createUserCart(userCart);
		} else {
			for (CartItem item : userCart.getCartItems()) {
				if (item.getProduct().getProductId() == cartItem.getProduct().getProductId()) {
					item.setQuantity(cartItem.getQuantity());
					cartManagerDao.addCartItem(item);
					break;
				}
			}
		}
	}

}
