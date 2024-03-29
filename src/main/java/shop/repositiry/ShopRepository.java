package shop.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    @Query(value = "SELECT * FROM shop WHERE shop_owner_id = :userId", nativeQuery = true)
    Shop getShopForShopOwner(@Param("userId") Long userId);
}
