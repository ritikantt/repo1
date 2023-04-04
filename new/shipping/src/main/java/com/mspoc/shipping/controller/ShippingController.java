package com.mspoc.shipping.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mspoc.msdevkit.exception.MsPlaformException;
import com.mspoc.shipping.entity.Shipment;
import com.mspoc.shipping.service.ShippingService;
import lombok.extern.slf4j.Slf4j;

/**
 * This controller class handles APIs related to shipping.
 *
 */
@RestController
@Slf4j
@RequestMapping("/shipments")
public class ShippingController {

  @Autowired
  private ShippingService shippingService;


  /**
   * Function to fetch all the shipments from database
   * 
   * @return List of Orders
   * @throws MsPlaformException
   */
  @GetMapping
  public List<Shipment> getAllOrders() throws MsPlaformException {
    log.info("Inside get all shipments function");
    return shippingService.findAllShipments();
  }
}
