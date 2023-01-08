package shop.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.entity.OrderProduct;

import java.util.List;


public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
    List<OrderProduct> findAllByIdIn(List<Long> id);

}
