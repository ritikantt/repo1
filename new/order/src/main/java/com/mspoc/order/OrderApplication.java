package com.mspoc.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * Main class for order microservice application
 *
 */
@SpringBootApplication
@ComponentScans({
    @ComponentScan({"com.mspoc.order.controller", "com.mspoc.msdevkit.exception.handler"})})
@EnableJpaRepositories("com.mspoc.order.repository")
@EntityScan("com.mspoc.order.entity")
public class OrderApplication {

  public static void main(String[] args) {
    SpringApplication.run(OrderApplication.class, args);
  }

}
