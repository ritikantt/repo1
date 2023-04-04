package com.mspoc.shipping.event;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class for receiving message through Kafka
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
