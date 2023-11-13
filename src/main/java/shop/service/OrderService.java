package shop.service;

import shop.dto.OrderDTO;
import shop.entity.enumeration.Status;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrdersForCustomer(Long userId);
    List<OrderDTO> getAllOrdersForShopOwner(Long userId);
    OrderDTO assignCourierToOrder(Long userId, Long orderId);
    List<OrderDTO> getAvailableOrdersCourier(Long userId);
    OrderDTO updateOrderInformation(OrderDTO orderDTO, Long userId);
    OrderDTO updateStatusForOwner(Long orderId, Long userId, Status status);
    OrderDTO completeOrder(Long orderId, Long userId);
    OrderDTO createOrderWithProduct(List<Long> productId, int amount, Long userId);
}
