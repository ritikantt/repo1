package com.mspoc.order.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.mspoc.order.entity.Orders;

/**
 * Repository class for handling all database operations for orders type
 *
 */
@Repository
public interface OrderRepository extends CrudRepository<Orders, String> {

  /**
   * Fetch all orders
   */
  public List<Orders> findAll();

  public Orders findByCartId(int cartId);
}
