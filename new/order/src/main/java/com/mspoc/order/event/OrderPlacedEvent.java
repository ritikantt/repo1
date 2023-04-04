package com.mspoc.order.event;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class for sending message through Kafka
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPlacedEvent {

  private int orderId;
  private String shipmentAddress;
  private Date orderDate;
}
