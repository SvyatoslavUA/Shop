package shop.repositiry;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order getOrderById(Long ID);

    @Query(value = "SELECT * FROM `order` WHERE customer_id = :userId", nativeQuery = true)
    List<Order> getAllOrdersForCustomer(@Param("userId") Long userId);

    @Query(value = "SELECT * FROM `order` WHERE Status = 'READY_TO_DELIVER'", nativeQuery = true)
    List<Order> getAvailableOrdersCourier();
}
