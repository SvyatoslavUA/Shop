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
    @Query(value = "SELECT p FROM Product p JOIN p.productsInShop ps WHERE ps.availableForOrdering = 1")
    List<Product> getAvailableProducts();
    @Query(value = "SELECT * FROM Orders o WHERE o.customerId = :userId", nativeQuery = true)
    List<Product> getAllProductsForCustomer(@Param("userId") Long userId);

    @Query(value = "SELECT pr.multiplier FROM product p JOIN producer pr ON p.producer_id = pr.id WHERE p.id = :productId", nativeQuery = true)
    Double getProducerMultiplierForProduct(@Param("productId") int productId);

    @Query(value = "SELECT p.material FROM product p WHERE p.id = :productId", nativeQuery = true)
    String getMaterialForProduct(@Param("productId") int productId);

    @Query(value = "SELECT p.price FROM product p WHERE p.id = :productId", nativeQuery = true)
    String getPriceForProduct(@Param("productId") int productId);

    @Query(value = "SELECT p.guarantee FROM product p WHERE p.id = :productId", nativeQuery = true)
    Double getGuaranteeForProduct(@Param("productId") int productId);
}
