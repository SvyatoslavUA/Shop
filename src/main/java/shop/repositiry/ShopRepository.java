package shop.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.entity.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    @Query(value = "SELECT * FROM shop o WHERE o.shopOwner = :userId", nativeQuery = true)
    Shop getShopForShopOwner(@Param("userId") Long userId);
}
