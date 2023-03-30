package com.mspoc.order.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mspoc.msdevkit.exception.MsPlaformException;
import com.mspoc.order.dto.OrderRequest;
import com.mspoc.order.entity.Orders;
import com.mspoc.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

/**
 * This controller class handles APIs related to order.
 *
 */
@RestController
@Slf4j
public class OrderController {

  @Autowired
  private OrderService orderService;


  /**
   * Function to fetch all the orders from database
   * 
   * @return List of Orders
   * @throws MsPlaformException
   */
  @GetMapping("/orders")
  public List<Orders> getAllOrders() throws MsPlaformException {
    log.info("Inside get all orders function");
    return orderService.findAllOrders();
  }


  /**
   * Function to place an order
   * 
   * @param orderRequest
   * @return response entity
   * @throws MsPlaformException
   */
  @PostMapping("/order/place")
  public ResponseEntity<String> placeOrder(@Valid @RequestBody OrderRequest orderRequest)
      throws MsPlaformException {
    log.info("Inside place order function");
    orderService.placeOrder(orderRequest);
    return new ResponseEntity<>("Order has been placed successfully", HttpStatus.CREATED);
  }
}
