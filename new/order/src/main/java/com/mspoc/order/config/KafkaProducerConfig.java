package com.mspoc.order.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.mspoc.order.event.OrderPlacedEvent;

/**
 * Class to configure ProducerFactory. This sets the strategy for creating Kafka Producer instances.
 *
 */
@Configuration
public class KafkaProducerConfig {

  @Value(value = "${spring.kafka.bootstrap-servers}")
  private String bootstrapAddress;

  /**
   * Function to create Producer Factory
   * 
   * @return ProducerFactory
   */
  @Bean
  public ProducerFactory<String, OrderPlacedEvent> orderProducerFactory() {
    Map<String, Object> configProps = new HashMap<>();
    configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
    configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    return new DefaultKafkaProducerFactory<>(configProps);
  }

  /**
   * Function to define bean for Kafka template
   * 
   * @return KafkaTemplate
   */
  @Bean
  public KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate() {
    return new KafkaTemplate<>(orderProducerFactory());
  }
}
