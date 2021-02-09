/**
 * 
 */
package com.mindtree.shoppingcart.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.shoppingcart.model.Product;
import com.mindtree.shoppingcart.service.ProductManagerService;

/**
 * @author M1017036
 *
 */
@Controller
public class ProductHomeController {

	/**
	 * cartManagerService
	 */
	@Autowired
	ProductManagerService productManagerService;

	/**
	 * Populate product map.
	 *
	 * @return productMapList map
	 */
	@ModelAttribute(name = "productMapList")
	public Map<String, List<Product>> populateProduct() {
		Map<String, List<Product>> products = productManagerService.fetchProducts();
		return products;
	}

	/**
	 * Populate product types list.
	 *
	 * @return productTypes list
	 */
	@ModelAttribute(name = "productTypes")
	public List<String> populateProductTypes() {
		List<String> productTypes = productManagerService.fetchProductTypes();
		return productTypes;
	}

	/**
	 * Search form model and view.
	 *
	 * @param session the session
	 * @param model   the model
	 * @return ModelAndView model and view
	 */
	@RequestMapping(value = "/productSearch", method = RequestMethod.GET)
	public ModelAndView SearchForm(HttpSession session, ModelMap model) {
		if (session.getAttribute("userDetail") != null) {
			return showForm();
		}
		return new ModelAndView("home");
	}

	/**
	 * Show form model and view.
	 *
	 * @return ModelAndView model and view
	 */
	@RequestMapping(value = "/productSearchForm", method = RequestMethod.POST)
	public ModelAndView showForm() {
		return new ModelAndView("productSearch");
	}

}
