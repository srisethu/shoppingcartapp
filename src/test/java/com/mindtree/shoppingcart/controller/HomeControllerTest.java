/**
 * 
 */
package com.mindtree.shoppingcart.controller;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.shoppingcart.model.User;

/**
 * @author M1017036
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {
	
	HttpSession session;
	ModelMap model;
	
	HomeController controller;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void homeSuccessTest() {
		controller = new HomeController();
		session = Mockito.mock(HttpSession.class);
		model = Mockito.mock(ModelMap.class);
		Mockito.when(session.getAttribute("userDetail")).thenReturn(new User());
		ModelAndView result = controller.home(session, model);
		assertEquals("forward:/productSearch", result.getViewName());
	}
	
	@Test
	public void homeFailTest() {
		controller = new HomeController();
		session = Mockito.mock(HttpSession.class);
		ModelAndView result = controller.home(session, model);
		assertEquals("home", result.getViewName());
	}

}
