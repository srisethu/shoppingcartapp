/**
 * 
 */
package com.mindtree.shoppingcart.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mindtree.shoppingcart.dao.repository.ProductManagerRepository;
import com.mindtree.shoppingcart.model.Product;

/**
 * The type Product manager dao.
 *
 * @author M1017036
 */
@Repository
public class ProductManagerDaoImpl implements ProductManagerDao {

	/**
	 * productrepo
	 */
	@Resource
	ProductManagerRepository productrepo;

	/**
	 * fetchAllProduct
	 *
	 * @return the list
	 */
	@Override
	public List<Product> fetchAllProduct() {
		return productrepo.findAll();
	}

	/**
	 * fetchAllProductType
	 *
	 * @return the list
	 */
	@Override
	public List<String> fetchAllProductType() {
		return productrepo.findAllProductType();
	}

	/**
	 * fetchProductById
	 *
	 * @param productId the product id
	 * @return the list
	 */
	@Override
	public List<Product> fetchProductById(Integer productId) {
		return productrepo.findByProductId(productId);
	}

	/**
	 * fetchProductByName
	 *
	 * @param productName the product name
	 * @return the list
	 */
	@Override
	public List<Product> fetchProductByName(String productName) {
		return productrepo.findByProdName(productName);
	}

}
