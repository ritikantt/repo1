package com.mspoc.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Products table entity mapping
 *
 */
@Entity
@Getter
@Setter
@ToString
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_TOKEN")
	@SequenceGenerator(name = "PRODUCT_TOKEN", initialValue = 101, allocationSize = 1)
	private int productId;
	private String productName;
	private String productCategory;
	private String productDescription;
	private int productPrice;
	private int discountId;
	private int productAvailable;

}