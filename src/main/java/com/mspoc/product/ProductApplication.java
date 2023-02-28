package com.mspoc.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main class for product application
 *
 */
@SpringBootApplication
@ComponentScans({ @ComponentScan({ "com.mspoc.product.controller"}) })
@EnableJpaRepositories("com.mspoc.product.repository")
@EntityScan("com.mspoc.product.entity")
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
