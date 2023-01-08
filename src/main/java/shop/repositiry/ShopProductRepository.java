package shop.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.entity.ShopProduct;

public interface ShopProductRepository extends JpaRepository<ShopProduct, Long> {
}
