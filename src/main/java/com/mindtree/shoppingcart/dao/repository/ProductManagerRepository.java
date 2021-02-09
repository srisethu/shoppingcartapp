/**
 * 
 */
package com.mindtree.shoppingcart.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.shoppingcart.model.Product;

/**
 * @author M1017036
 *
 */
public interface ProductManagerRepository extends JpaRepository<Product, Integer>{

	/**
	 * @return
	 */
	@Query(value = "select distinct(p.PRODUCT_TYPE) from Product p", nativeQuery = true )
	List<String> findAllProductType();

	/**
	 * @param productId
	 * @return
	 */
	List<Product> findByProductId(Integer productId);

	/**
	 * @param productName
	 * @return
	 */
	List<Product> findByProdName(String productName);

}
