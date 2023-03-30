package com.mspoc.shipping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.KafkaListener;
import com.mspoc.msdevkit.exception.MsPlaformException;
import com.mspoc.shipping.event.OrderPlacedEvent;
import com.mspoc.shipping.service.ShippingService;
import lombok.extern.slf4j.Slf4j;

/**
 * Main class for shipping microservice application
 *
 */
@SpringBootApplication
@ComponentScans({
    @ComponentScan({"com.mspoc.shipping.controller", "com.mspoc.msdevkit.exception.handler"})})
@EnableJpaRepositories("com.mspoc.shipping.repository")
@EntityScan("com.mspoc.shipping.entity")
@Slf4j
public class ShippingApplication {

  @Autowired
  private ShippingService shippingService;
  
  public static void main(String[] args) {
    SpringApplication.run(ShippingApplication.class, args);
  }

  @KafkaListener(topics = "notificationTopic")
  public void handleNotification(OrderPlacedEvent orderPlacedEvent) throws MsPlaformException {
    log.info("Received Notification for Order - {}", orderPlacedEvent.getOrderId());
    shippingService.addShipmentForOrder(orderPlacedEvent);
  }
}
