package com.mspoc.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mspoc.product.dto.ProductRequest;
import com.mspoc.product.entity.Products;
import com.mspoc.product.service.ProductService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

/**
 * This controller class handles APIs related to product.
 *
 */
@RestController
@Slf4j
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * Function to fetch all the products from database
	 * 
	 * @return List of Products
	 */
	@GetMapping("/products")
	public List<Products> getAllProducts() {
		log.info("Inside get all products function");
		return productService.findAllProducts();
	}

	/**
	 * Function to fetch the product details for a given product id
	 * 
	 * @param productId
	 * @return product details
	 */
	@GetMapping("/product")
	public Products getProduct(@RequestParam int productId) {
		log.info("Inside get product details function");
		return productService.findProductByProductId(productId);
	}

	/**
	 * Function to delete a product from the database
	 * 
	 * @param productId
	 * @return response entity
	 */
	@DeleteMapping("/product/delete")
	public ResponseEntity<String> deleteProduct(@RequestParam int productId) {
		log.info("Inside delete product function");
		productService.deleteProductByProductId(productId);
		return new ResponseEntity<>("Product is deleted", HttpStatus.OK);
	}

	/**
	 * Function to add a product to the database
	 * 
	 * @param productRequest
	 * @return response entity
	 */
	@PostMapping("/product/add")
	public ResponseEntity<String> addProduct(@Valid @RequestBody ProductRequest productRequest)
			 {
		log.info("Inside add product function");
		productService.addProduct(productRequest);
		return new ResponseEntity<>("Product has been added successfully", HttpStatus.CREATED);
	}

}
