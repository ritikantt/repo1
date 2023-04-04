package com.mspoc.shipping.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.mspoc.shipping.event.OrderPlacedEvent;

/**
 * Config class for Kafka Consumer
 *
 */
@EnableKafka
@Configuration
public class KafkaConsumerConfig {

  @Value(value = "${spring.kafka.bootstrap-servers}")
  private String bootstrapAddress;

  @Value(value = "${spring.kafka.consumer.group-id}")
  private String groupId;

  @Value(value = "${spring.kafka.consumer.properties.spring.json.type.mapping}")
  private String typeMapping;

  /**
   * Function to create consumer factory
   * 
   * @return ConsumerFactory
   */
  @Bean
  public ConsumerFactory<String, OrderPlacedEvent> orderConsumerFactory() {
    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    props.put(JsonDeserializer.TYPE_MAPPINGS, typeMapping);
    return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
        new JsonDeserializer<>(OrderPlacedEvent.class, false));
  }

  /**
   * Function to define kafka listener factory
   * 
   * @return ConsumerFactory
   */
  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, OrderPlacedEvent> orderKafkaListenerContainerFactory() {

    ConcurrentKafkaListenerContainerFactory<String, OrderPlacedEvent> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(orderConsumerFactory());
    return factory;
  }
}
