/**
 * 
 */
package com.mindtree.shoppingcart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author M1017036
 *
 */
@SpringBootApplication
@EnableTransactionManagement
public class ShoppingCartApplication {
	
	/**
	 * LOGGER
	 */
	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartApplication.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		logger.info("Starting ShoppingCart Application");
		SpringApplication.run(ShoppingCartApplication.class, args);
	}
}
