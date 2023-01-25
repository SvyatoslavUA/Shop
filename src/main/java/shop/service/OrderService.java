package shop.service;

import shop.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrdersForCustomer(Long userId);
    List<OrderDTO> getAllOrdersForShopOwner(Long userId);
    OrderDTO assignCourierToOrder(Long userId, Long orderId);
    List<OrderDTO> getAvailableOrdersCourier(Long userId);
    OrderDTO updateOrderInformation(OrderDTO orderDTO, Long userId);
}
