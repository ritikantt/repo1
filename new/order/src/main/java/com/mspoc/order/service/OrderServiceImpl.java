package com.mspoc.order.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.mspoc.msdevkit.exception.MsPlaformException;
import com.mspoc.order.dto.OrderRequest;
import com.mspoc.order.entity.Orders;
import com.mspoc.order.event.OrderPlacedEvent;
import com.mspoc.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementation class for Order service
 *
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderRepository orderRepository;

  private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate = null;

  /**
   * Function to find all the orders from orders table
   */
  @Override
  public List<Orders> findAllOrders() throws MsPlaformException {
    try {
      List<Orders> orders = orderRepository.findAll();
      if (!orders.isEmpty()) {
        return orders;
      }
    } catch (Exception e) {
      log.error("Error in find all orders function", e);
      throw new MsPlaformException(HttpStatus.NOT_FOUND.name(),
          "An Error occurred while fetching all orders");
    }
    return Collections.emptyList();
  }

  /**
   * Function to add order to the orders table
   */
  @Override
  public void placeOrder(OrderRequest orderRequest) throws MsPlaformException {
    try {
      Orders order = new Orders();
      order.setCustomerId(orderRequest.getCustomerId());
      order.setCartId(orderRequest.getCartId());
      order.setShipmentAddress(orderRequest.getShipmentAddress());
      order.setOrderDate(new Date());
      orderRepository.save(order);
      sendOrderPlacedEvent(orderRequest.getCartId());
    } catch (Exception e) {
      log.error("Error in place order method", e);
      throw new MsPlaformException(HttpStatus.INTERNAL_SERVER_ERROR.name(),
          "Sorry, Could not place your Order");
    }
  }


  private void sendOrderPlacedEvent(int cartId) throws MsPlaformException {
    try {
      // fetch newly place order
      Orders newOrder = orderRepository.findByCartId(cartId);
      kafkaTemplate.send("notificationTopic",
          new OrderPlacedEvent(newOrder.getOrderId(), newOrder.getShipmentAddress()));
    } catch (Exception e) {
      log.error("Error in place order method", e);
      throw new MsPlaformException(HttpStatus.INTERNAL_SERVER_ERROR.name(),
          "Sorry, Could not place your Order");
    }
  }
}
