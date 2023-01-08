package shop.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.entity.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
