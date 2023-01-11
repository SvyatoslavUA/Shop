package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dto.OrderDTO;
import shop.dto.UserDTO;
import shop.entity.Order;
import shop.entity.User;
import shop.entity.enumeration.EmployeeRole;
import shop.entity.enumeration.Status;
import shop.exeption.ServiceException;
import shop.mapper.OrderToOrderMapperDTO;
import shop.repositiry.OrderRepository;
import shop.repositiry.UserRepository;
import shop.service.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderToOrderMapperDTO orderToOrderMapperDTO;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;


    public List<OrderDTO> getAllOrdersForCustomer(final Long userId){
        return orderRepository.getAllOrdersForCustomer(userId).stream()
                .map(orderToOrderMapperDTO :: toDTO).collect(Collectors.toList());
    }

    public List<OrderDTO> getAllOrdersForShopOwner(final Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new ServiceException(400, "!!!"));
        if(user.getEmployeeRole() != EmployeeRole.SHOP_OWNER){
            throw new ServiceException(400, "!!!");
        }
        return orderRepository.getAllOrdersForCustomer(userId).stream()
                .map(orderToOrderMapperDTO :: toDTO).collect(Collectors.toList());
    }

    public List<OrderDTO> getAvailableOrdersCourier(final UserDTO userDTO){
        return orderRepository.findAll().stream()
                .filter(e -> e.getStatus() == Status.READY_TO_DELIVER)
                .filter(e -> userDTO.getEmployeeRole() == EmployeeRole.COURIER)
                .map(orderToOrderMapperDTO :: toDTO).collect(Collectors.toList());
    }

    public OrderDTO assignCourierToOrder(final Long userId, final Long orderId){
        Order order = orderRepository.getOrderById(orderId);
        order.setStatus(Status.DELIVERING);

        User user = userRepository.getUserById(userId);
        order.setCourierId(user);

        return orderToOrderMapperDTO.toDTO(order);
    }

    public OrderDTO updateStatusForShopOwner(OrderDTO orderDTO){
        return null;
    }


}
