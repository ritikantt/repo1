package com.mspoc.shipping.entity;

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
 * Shipment table entity mapping
 *
 */
@Entity
@Getter
@Setter
@ToString
public class Shipment {
  
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SHIPMENT_TOKEN")
  @SequenceGenerator(name = "SHIPMENT_TOKEN", initialValue = 1, allocationSize = 1)
  private int shipmentId;
  private int orderId;
  private Date shipmentDate;
  private String shipmentAddress;
}
