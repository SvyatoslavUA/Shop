package shop.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.entity.ShopProduct;

import java.util.List;

@Repository
public interface ShopProductRepository extends JpaRepository<ShopProduct, Long> {
    @Query(value = "SELECT o FROM ShopProduct o WHERE o.product.id = :productId AND o.shop.id = :shopId", nativeQuery = true)
    ShopProduct getShopProductByProductIdAndShopId(@Param("productId") Long productId, @Param("shopId") Long shopId);

    @Query(value = "SELECT o FROM ShopProduct o WHERE o.availableForOrdering = ?true", nativeQuery = true)
    List<ShopProduct> getAvailableProducts();

    @Query(value = "SELECT o FROM ShopProduct o WHERE o.availableForOrdering = ?true AND o.productId = :productId", nativeQuery = true)
    List<ShopProduct> getAvailableProductsById(@Param("productId") Long productId);
}
