/**
 * 
 */
package com.mindtree.shoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.shoppingcart.dao.UserManagerDao;
import com.mindtree.shoppingcart.model.User;

/**
 * @author M1017036
 *
 */
@Service
@Transactional(rollbackFor = DataAccessException.class)
public class UserManagerServiceImpl implements UserManagerService{
	
	/**
	 * userManagerDao
	 */
	@Autowired
	private UserManagerDao userManagerDao;
	
	/**
	 * @param user
	 * @return
	 */
	public User getUserDetails(User user) {
		return userManagerDao.getUser(user);
	}

	/**
	 * @param user
	 * @return
	 */
	public User saveUser(User user) {
		return userManagerDao.saveUser(user);
	}

	/**
	 * saveUserDetails
	 */
	@Override
	public User saveUserDetails(User user) throws RuntimeException{
		return userManagerDao.saveUser(user);
	}
}
