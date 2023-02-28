package com.mspoc.product.service;

import java.util.List;

import com.mspoc.product.dto.ProductRequest;
import com.mspoc.product.entity.Products;

/**
 * Service class to handle the operations for product
 *
 */
public interface ProductService {

	/**
	 * Function to find all the products from products table
	 * 
	 * @return list of products
	 */
	List<Products> findAllProducts();

	/**
	 * Function to find the product details for product id
	 * 
	 * @param productId
	 * @return product details
	 */
	Products findProductByProductId(int productId);

	/**
	 * Function to delete product by product id
	 * 
	 * @param productId
	 */
	void deleteProductByProductId(int productId);

	/**
	 * Function to add product to the products table
	 * 
	 * @param productrequest
	 */
	void addProduct(ProductRequest productrequest);

	/**
	 * Function to check if product exists in the table with the given product id
	 * 
	 * @param productId
	 * @return true/false
	 */
	Boolean checkProductExists(int productId);
}
