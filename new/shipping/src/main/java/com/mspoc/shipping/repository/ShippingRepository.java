package com.mspoc.shipping.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.mspoc.shipping.entity.Shipment;

/**
 * Repository class for handling all database operations for Shipping
 *
 */
@Repository
public interface ShippingRepository extends CrudRepository<Shipment, String>  {

  /**
   * Fetch all shipments
   */
  List<Shipment> findAll();
}
