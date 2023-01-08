package shop.service;

import shop.dto.OrderDTO;
import shop.dto.UserDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrdersForCustomer(UserDTO userDTO);
    List<OrderDTO> getAllOrdersForShopOwner();
    List<OrderDTO> getAvailableOrdersCourier();
    OrderDTO updateStatusForShopOwner(OrderDTO user);
    OrderDTO updateStatusForCourier(OrderDTO user);
    OrderDTO takeOrderForCourier(OrderDTO user);


}
