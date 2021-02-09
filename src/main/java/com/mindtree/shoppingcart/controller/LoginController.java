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
public class LoginController {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    /**
     * validator
     */
    @Autowired
    private UserDetailValidator validator;

    /**
     * userManagerService
     */
    @Autowired
    private UserManagerService userManagerService;

    /**
     * showForm
     *
     * @return ModelAndView
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("login", "userDetail", new User());
    }

    /**
     * @param user
     * @param result
     * @param model
     * @param session
     * @return ModelAndView
     */
    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public ModelAndView submit(@Valid @ModelAttribute("userDetail") User user,
							   BindingResult result,
							   ModelMap model,
                               HttpSession session) {
        validator.validate(user, result);
        String returnFlag = "login";
        if (result.hasErrors()) {
            LOGGER.error("validation error");
            return new ModelAndView(returnFlag);
        }
        User loggedInUser = userManagerService.getUserDetails(user);
        if (loggedInUser == null) {
            result.rejectValue("username", "", "Invalid UserName or Password");
            return new ModelAndView(returnFlag);
        }
        LOGGER.info("User Logged in successfully");
        model.addAttribute("userDetail", loggedInUser);
        session.setAttribute("userDetail", loggedInUser);
        return new ModelAndView("forward:/productSearchForm", model);
    }

}
