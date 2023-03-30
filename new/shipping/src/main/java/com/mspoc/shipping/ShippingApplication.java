package com.mspoc.shipping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.KafkaListener;
import com.mspoc.shipping.event.OrderPlacedEvent;
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

  public static void main(String[] args) {
    SpringApplication.run(ShippingApplication.class, args);
  }

  @KafkaListener(topics = "notificationTopic")
  public void handleNotification(OrderPlacedEvent orderPlacedEvent) {
    log.info("Received Notification for Order - {}", orderPlacedEvent.getOrderId());
    
  }
}
