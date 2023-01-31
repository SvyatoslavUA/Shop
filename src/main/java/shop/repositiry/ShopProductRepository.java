package shop.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.entity.ShopProduct;

public interface ShopProductRepository extends JpaRepository<ShopProduct, Long> {
    @Query(value = "SELECT * FROM ShopProduct o WHERE o.product = :productId", nativeQuery = true)
    ShopProduct getShopProductByProductId(@Param("productId") Long userId);
}
