/**
 * 
 */
package com.mindtree.shoppingcart.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.shoppingcart.model.CartItem;
import com.mindtree.shoppingcart.model.User;
import com.mindtree.shoppingcart.service.CartManagerService;

/**
 * @author M1017036
 *
 */
@Controller
public class ShoppingCartController {
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartController.class);
	
	/**
	 * cartManagerService
	 */
	@Autowired
	CartManagerService cartManagerService;

	/**
	 * View cart details model and view.
	 *
	 * @param session the session
	 * @param model   the model
	 * @return viewCartDetails model and view
	 */
	@RequestMapping(value="/viewCartDetails", method = RequestMethod.GET)
	public ModelAndView viewCartDetails(HttpSession session, ModelMap model) {
		if (session.getAttribute("userDetail") != null) {
			User loggedInUser = (User) session.getAttribute("userDetail");
			Map<String, List<CartItem>> cartItems =  cartManagerService.fetchCartItems(loggedInUser);
			model.addAttribute("cartItemsMapList", cartItems);
			return new ModelAndView("cartDetails");
		} else {
			LOGGER.info("new user re-directing to home screen");
			return new ModelAndView("home");
		}
	}
}
