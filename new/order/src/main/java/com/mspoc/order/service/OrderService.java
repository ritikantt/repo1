package com.mspoc.order.service;

import java.util.List;
import com.mspoc.msdevkit.exception.MsPlaformException;
import com.mspoc.order.dto.OrderRequest;
import com.mspoc.order.entity.Orders;

/**
 * Service class to handle the operations for order
 *
 */
public interface OrderService {

  /**
   * Function to find all the orders from orders table
   * 
   * @return list of orders
   * @throws MsPlaformException
   */
  List<Orders> findAllOrders() throws MsPlaformException;


  /**
   * Function to place order and add details in orders table
   * 
   * @param orderRequest
   * @throws MsPlaformException
   */
  void placeOrder(OrderRequest orderRequest) throws MsPlaformException;
}
