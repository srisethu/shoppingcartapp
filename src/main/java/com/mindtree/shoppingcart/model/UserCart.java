/**
 * 
 */
package com.mindtree.shoppingcart.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author M1017036
 *
 */
@Entity
@Table(name = "USER_CART_ITEM")
public class UserCart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5874872571486930414L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CART_ID", nullable = false)
	private Integer cartId;

	@OneToOne(fetch = FetchType.LAZY)
	private User user;

	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<CartItem> cartItems;

	/**
	 * @return the cartId
	 */
	public Integer getCartId() {
		return cartId;
	}

	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the cartItems
	 */
	public Set<CartItem> getCartItems() {
		return cartItems;
	}

	/**
	 * @param cartItems the cartItems to set
	 */
	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		result = prime * result + ((cartItems == null) ? 0 : cartItems.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserCart other = (UserCart) obj;
		if (cartId == null) {
			if (other.cartId != null)
				return false;
		} else if (!cartId.equals(other.cartId))
			return false;
		if (cartItems == null) {
			if (other.cartItems != null)
				return false;
		} else if (!cartItems.equals(other.cartItems))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserCart [cartId=" + cartId + ", user=" + user + ", cartItems=" + cartItems + "]";
	}



}
