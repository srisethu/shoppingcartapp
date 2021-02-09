/**
 * 
 */
package com.mindtree.shoppingcart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.mindtree.shoppingcart.dao.ProductManagerDao;
import com.mindtree.shoppingcart.model.Apparel;
import com.mindtree.shoppingcart.model.Book;
import com.mindtree.shoppingcart.model.Product;
import com.mindtree.shoppingcart.model.ProductSearch;

/**
 * @author M1017036
 *
 */
@Service
@Transactional
public class ProductManagerServiceImpl implements ProductManagerService {
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductManagerServiceImpl.class);
	
	/**
	 * productManagerDao
	 */
	@Autowired
	private ProductManagerDao productManagerDao;

	/**
	 *fetchProducts
	 */
	@Override
	public Map<String, List<Product>> fetchProducts() {
		Map<String, List<Product>> productMap = new TreeMap<String, List<Product>>();
		List<Product> products = productManagerDao.fetchAllProduct();
		for (Product product : products) {
			updateProductMap(productMap, product);
		}
		return productMap;
	}
	

	/**
	 * @param productMap 
	 * @param product
	 */
	private void updateProductMap(Map<String, List<Product>> productMap, Product product) {
		String productType = null;
		if (product instanceof Book ) {
			productType = "BOOK";
		} else if (product instanceof Apparel ) {
			productType = "APPAREL";
		}
		if (productType != null) {
			List<Product> productList = null;
			if (productMap.get(productType) != null) {
				productList = productMap.get(productType);
			} else {
				productList = new ArrayList<Product>();
				productMap.put(productType, productList);
			}
			productList.add(product);
		}
	}


	/**
	 *fetchProductTypes
	 */
	@Override
	public List<String> fetchProductTypes() {
		return productManagerDao.fetchAllProductType();
	}


	/**
	 *fetchProductTypesByCriteria
	 */
	@Override
	public Map<String, List<Product>> fetchProductTypesByCriteria(ProductSearch productSearch) {
		LOGGER.info("fetch Product Types by Criteria");
		Map<String, List<Product>> productMap = new TreeMap<String, List<Product>>();
		List<Product> products = null;
		if (productSearch.getProductId() != null) {
			products = productManagerDao.fetchProductById(productSearch.getProductId());
			if (!StringUtils.isEmpty(productSearch.getProductName())) {
				for (Product product : products) {
					if (!product.getProdName().equalsIgnoreCase(productSearch.getProductName())) {
						products.remove(product);
					}
				}
			}
		} else if (!StringUtils.isEmpty(productSearch.getProductName())) {
			products = productManagerDao.fetchProductByName(productSearch.getProductName());
		} else {
			products = productManagerDao.fetchAllProduct();
		}
		if (products != null) {
			for (Product product : products) {
				updateProductMap(productMap, product);
			}
		}
		if (!StringUtils.isEmpty(productSearch.getProductType())) {
			productMap.keySet().removeIf(key-> !key.equalsIgnoreCase(productSearch.getProductType()));
		}
		return productMap;
	}

}
