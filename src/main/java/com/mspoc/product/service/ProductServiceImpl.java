package com.mspoc.product.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mspoc.product.dto.ProductRequest;
import com.mspoc.product.entity.Products;
import com.mspoc.product.repository.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementation class for Product service
 *
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	/**
	 * Function to fetch all the products from database
	 */
	@Override
	public List<Products> findAllProducts() {
		try {
			List<Products> products = productRepository.findAll();
			if (!products.isEmpty()) {
				return products;
			}
		} catch (Exception e) {
			log.error("Error in find all products function", e);
			//throw new MsPlaformException(HttpStatus.NOT_FOUND.name(), "An Error occurred while fetching all products");
		}
		return Collections.emptyList();
	}

	/**
	 * Function to fetch the product details for a given product id
	 */
	@Override
	public Products findProductByProductId(int productId)  {
		checkIdIsValid(productId);
		try {
			Products product = productRepository.findByProductId(productId);
			if (null != product) {
				return product;
			} else {
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			log.error("Error in find by product id function", e);
			//throw new MsPlaformException(HttpStatus.NOT_FOUND.name(), "Could not find product with the given id");
		}
		return null;
	}

	/**
	 * Function to delete a product from the database
	 */
	@Override
	@Transactional(rollbackOn = Exception.class)
	public void deleteProductByProductId(int productId) {
		checkIdIsValid(productId);
		if (Boolean.FALSE.equals(checkProductExists(productId))) {
			log.error("The product you are trying to delete does not exist");
			//throw new MsPlaformException(HttpStatus.NOT_FOUND.name(),
			//		"The product you are trying to delete does not exist");
		}
		try {
			productRepository.deleteByProductId(productId);
		} catch (Exception e) {
			log.error("Error in delete product function", e);
			//throw new MsPlaformException(HttpStatus.INTERNAL_SERVER_ERROR.name(),
			//		"Could not delete product with given id");
		}
	}

	/**
	 * Function to add product to the products table
	 */
	@Override
	public void addProduct(ProductRequest productRequest) {
		try {
			Products newProduct = new Products();
			newProduct.setProductName(productRequest.getProductName());
			newProduct.setProductCategory(productRequest.getProductCategory());
			newProduct.setProductDescription(productRequest.getProductDescription());
			newProduct.setProductPrice(productRequest.getProductPrice());
			newProduct.setDiscountId(productRequest.getDiscountId());
			newProduct.setProductAvailable(productRequest.getProductAvailable());
			productRepository.save(newProduct);
		} catch (Exception e) {
			log.error("Error in add product method", e);
			//throw new MsPlaformException(HttpStatus.INTERNAL_SERVER_ERROR.name(), "Could not add the product");
		}
	}

	/**
	 * Function to check if product exists in the table with the given product id
	 */
	@Override
	public Boolean checkProductExists(int productId) {
		try {
			Products product = productRepository.findByProductId(productId);
			if (null != product) {
				return Boolean.TRUE;
			} else {
				return Boolean.FALSE;
			}
		} catch (Exception e) {
			log.error("Error in check product exists function", e);
			//throw new MsPlaformException(HttpStatus.INTERNAL_SERVER_ERROR.name(),
				//	"An error occur during deleting product");
		}
		return null;
	}

	/**
	 * Function will check if id is zero or negative number. If yes, it will throw
	 * exception
	 * 
	 * @param id
	 */
	private void checkIdIsValid(int id) {
		if (id <= 0) {
			log.error("The product id cannot be zero or a negative number");
			//throw new MsPlaformException(HttpStatus.BAD_REQUEST.name(),
					//"The product id cannot be zero or a negative number");
		}
	}

}
