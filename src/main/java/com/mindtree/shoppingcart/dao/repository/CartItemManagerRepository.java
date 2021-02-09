/**
 * 
 */
package com.mindtree.shoppingcart.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.shoppingcart.model.CartItem;

/**
 * @author M1017036
 *
 */
public interface CartItemManagerRepository  extends JpaRepository<CartItem, Integer>{

}
