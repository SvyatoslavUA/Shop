package shop.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.entity.Order;
import shop.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM Orders o WHERE o.customerId = :userId", nativeQuery = true)
    List<Product> getAllProductsForCustomer(@Param("userId") Long userId);
}
