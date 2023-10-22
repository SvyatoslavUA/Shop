package shop.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.entity.Product;
import shop.entity.ShopProduct;

import java.util.List;

@Repository
public interface ShopProductRepository extends JpaRepository<ShopProduct, Long> {
    @Query(value = "SELECT * FROM `shop_product` WHERE `product_id` = :productId AND `shop_id` = :shopId", nativeQuery = true)
    ShopProduct getShopProductByProductIdAndShopId(@Param("productId") Long productId, @Param("shopId") Long shopId);



    @Query(value = "SELECT * FROM `shop_product` WHERE `availableForOrdering` = 1 AND `product_id` = :productId", nativeQuery = true)
    List<ShopProduct> getAvailableProductsById(@Param("productId") Long productId);
}
