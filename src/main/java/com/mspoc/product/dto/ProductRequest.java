package com.mspoc.product.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * DTO class for product request
 *
 */
@Data
public class ProductRequest {
	@NotBlank(message = "The product name is required")
	@Size(min = 3, max = 100, message = "The length of product name must be between 3 and 100 characters")
	private String productName;

	@NotBlank(message = "The product category is required")
	@Size(min = 3, max = 30, message = "The length of product category must be between 3 and 30 characters")
	private String productCategory;

	@NotBlank(message = "The product description is required")
	@Size(min = 3, max = 200, message = "The length of product description must be between 3 and 200 characters")
	private String productDescription;

	@NotNull(message = "The product price is required")
	@Positive(message = "The product price must be greater than 0")
	private int productPrice;

	@NotNull(message = "The discount id is required")
	private int discountId;

	@NotNull(message = "The product availablity is required")
	@Min(value = 0, message = "The product availablity must be a positive number")
	private int productAvailable;
}
