package com.mspoc.shipping.service;

import java.util.List;
import com.mspoc.msdevkit.exception.MsPlaformException;
import com.mspoc.shipping.entity.Shipment;
import com.mspoc.shipping.event.OrderPlacedEvent;

/**
 * Service class to handle the operations for shipping
 *
 */
public interface ShippingService {

  /**
   * Function to find all the shipments from shipment table
   * 
   * @return list of shipment
   * @throws MsPlaformException
   */
  public List<Shipment> findAllShipments() throws MsPlaformException;

  /**
   * Function to add new shipping entry into the shipment table
   * 
   * @param orderPlacedEvent
   * @throws MsPlaformException
   */
  public void addShipmentForOrder(OrderPlacedEvent orderPlacedEvent) throws MsPlaformException;
}
