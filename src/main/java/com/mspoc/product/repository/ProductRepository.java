package com.mspoc.product.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mspoc.product.entity.Products;

/**
 * Respository class for handling all database operations for Products type
 *
 */
@Repository
public interface ProductRepository extends CrudRepository<Products, String> {

	Products findByProductId(int productId);

	List<Products> findAll();

	long deleteByProductId(int productId);
	
}
