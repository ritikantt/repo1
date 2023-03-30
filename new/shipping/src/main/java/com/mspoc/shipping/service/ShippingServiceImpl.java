package com.mspoc.shipping.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.mspoc.msdevkit.exception.MsPlaformException;
import com.mspoc.shipping.entity.Shipment;
import com.mspoc.shipping.event.OrderPlacedEvent;
import com.mspoc.shipping.repository.ShippingRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementation class for Shipping service
 *
 */
@Service
@Slf4j
public class ShippingServiceImpl implements ShippingService {

  @Autowired
  private ShippingRepository shippingRepository;

  /**
   * Function to find all the shipments from shipment table
   */
  @Override
  public List<Shipment> findAllShipments() throws MsPlaformException {
    try {
      List<Shipment> shipments = shippingRepository.findAll();
      if (!shipments.isEmpty()) {
        return shipments;
      }
    } catch (Exception e) {
      log.error("Error in find all shipment function", e);
      throw new MsPlaformException(HttpStatus.NOT_FOUND.name(),
          "An Error occurred while fetching all shipments");
    }
    return Collections.emptyList();
  }

  @Override
  public void addShipmentForOrder(OrderPlacedEvent orderPlacedEvent) throws MsPlaformException {
    try {
      Shipment shipment = new Shipment();
      shipment.setOrderId(orderPlacedEvent.getOrderId());
      shipment.setShipmentAddress(orderPlacedEvent.getShipmentAddress());
      shipment.setShipmentDate(new Date());
      shippingRepository.save(shipment);
    } catch (Exception e) {
      log.error("Error in add shipment order method", e);
      throw new MsPlaformException(HttpStatus.INTERNAL_SERVER_ERROR.name(),
          "Sorry, Could not add shipment for the Order");
    }
  }
}
