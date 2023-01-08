package shop.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
