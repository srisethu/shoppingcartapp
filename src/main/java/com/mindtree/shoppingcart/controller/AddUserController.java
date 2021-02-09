/**
 * 
 */
package com.mindtree.shoppingcart.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.shoppingcart.model.User;
import com.mindtree.shoppingcart.service.UserManagerService;
import com.mindtree.shoppingcart.valiadtor.UserDetailValidator;

/**
 * @author M1017036
 *
 */
@Controller
public class AddUserController {

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(AddUserController.class);

	/**
	 * UserDetailValidator
	 */
	@Autowired
	private UserDetailValidator validator;

	/**
	 * UserManagerService
	 */
	@Autowired
	private UserManagerService userManagerService;

	/**
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView registrationForm() {
		return new ModelAndView("addUser", "userDetail", new User());
	}

	/**
	 * Submit model and view.
	 *
	 * @param user    the user
	 * @param result  the result
	 * @param model   the model
	 * @param session the session
	 * @return ModelAndView model and view
	 */
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView submit(@Valid @ModelAttribute("userDetail") User user, BindingResult result, ModelMap model,
			HttpSession session) {
		validator.validate(user, result);
		String returnFlag = "addUser";
		if (result.hasErrors()) {
			LOGGER.error("validation error");
			return new ModelAndView(returnFlag);
		}
		User loggedInUser;
		try {
			loggedInUser = userManagerService.saveUserDetails(user);
		} catch (RuntimeException e) {
			result.rejectValue("username", "", "Invalid UserName or UserName already exists");
			LOGGER.debug("Invalid UserName or UserName already exists " + e.getStackTrace());
			return new ModelAndView(returnFlag);
		}
		LOGGER.info("User created successfully");
		model.addAttribute("userDetail", loggedInUser);
		session.setAttribute("userDetail", loggedInUser);
		return new ModelAndView("forward:/productSearchForm", model);
	}

}
