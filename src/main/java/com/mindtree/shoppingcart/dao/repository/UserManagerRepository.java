/**
 * 
 */
package com.mindtree.shoppingcart.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.shoppingcart.model.User;

/**
 * @author M1017036
 *
 */
public interface UserManagerRepository extends JpaRepository<User, Integer>{
	
	/**
	 * @param username
	 * @param password
	 * @return
	 */
	List<User> findByUsernameAndPassword(String username, String password);

}
