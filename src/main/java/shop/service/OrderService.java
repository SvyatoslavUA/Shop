package shop.service;

import shop.dto.OrderDTO;
import shop.dto.UserDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrdersForCustomer(Long userId);
    List<OrderDTO> getAllOrdersForShopOwner(UserDTO userDTO);
    OrderDTO assignCourierToOrder(Long userId, Long orderId);
    List<OrderDTO> getAvailableOrdersCourier(UserDTO userDTO);
    OrderDTO updateStatusForShopOwner(OrderDTO user);


}
