package edu.unimagdalena.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.unimagdalena.api.entity.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    @Query("SELECT oi FROM OrderItem oi WHERE oi.order.id = ?1")
    List<OrderItem> findByOrderId(Long orderId);

    @Query("SELECT oi FROM OrderItem oi WHERE oi.product.id = ?1")
    List<OrderItem> findByProductId(Long productId);

    @Query("SELECT COALESCE(SUM(oi.unitPrice), 0) FROM OrderItem oi WHERE oi.product.id = ?1")
    Float calculateTotalSalesForProduct(Long productId);
}
