package com.mspoc.order.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * DTO class for order request
 *
 */
@Data
public class OrderRequest {
  
  @NotNull(message = "The customer id is required")
  @Positive(message = "The customer id must be greater than 0")
  private int customerId;
  
  @NotNull(message = "The cart id is required")
  @Positive(message = "The cart id must be greater than 0")
  private int cartId;
  
  @NotBlank(message = "The Shipping address is required")
  @Size(min = 4, max = 50,
      message = "The length of shipping address must be between 4 and 50 characters")
  private String shipmentAddress;
}