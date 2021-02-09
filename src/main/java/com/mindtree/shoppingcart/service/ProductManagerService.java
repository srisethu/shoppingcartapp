/**
 * 
 */
package com.mindtree.shoppingcart.service;

import java.util.List;
import java.util.Map;

import com.mindtree.shoppingcart.model.Product;
import com.mindtree.shoppingcart.model.ProductSearch;

/**
 * @author M1017036
 *
 */
public interface ProductManagerService {

	/**
	 * @return
	 */
	Map<String, List<Product>> fetchProducts();

	/**
	 * @return
	 */
	List<String> fetchProductTypes();
	
	/**
	 * @return
	 */
	Map<String, List<Product>> fetchProductTypesByCriteria(ProductSearch productSearch);

}
