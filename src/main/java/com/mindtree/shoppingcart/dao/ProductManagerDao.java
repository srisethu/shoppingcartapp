/**
 * 
 */
package com.mindtree.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mindtree.shoppingcart.model.Product;

/**
 * The interface Product manager dao.
 *
 * @author M1017036
 */
@Repository
public interface ProductManagerDao {

	/**
	 * Fetch all product list.
	 *
	 * @return list
	 */
	List<Product> fetchAllProduct();

	/**
	 * Fetch all product type list.
	 *
	 * @return list
	 */
	List<String> fetchAllProductType();

	/**
	 * Fetch product by id list.
	 *
	 * @param productId the product id
	 * @return list
	 */
	List<Product> fetchProductById(Integer productId);

	/**
	 * Fetch product by name list.
	 *
	 * @param productName the product name
	 * @return list
	 */
	List<Product> fetchProductByName(String productName);

}
