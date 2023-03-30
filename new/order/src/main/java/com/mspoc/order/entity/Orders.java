package com.mspoc.order.entity;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Orders table entity mapping
 *
 */
@Entity
@Getter
@Setter
@ToString
public class Orders {
  
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_TOKEN")
  @SequenceGenerator(name = "ORDER_TOKEN", initialValue = 1, allocationSize = 1)
  private int orderId;
  private int customerId;
  private int cartId;
  private Date orderDate;
  private String shipmentAddress;
}
