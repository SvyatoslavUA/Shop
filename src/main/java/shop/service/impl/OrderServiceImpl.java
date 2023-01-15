package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dto.OrderDTO;
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
import java.util.Objects;
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
                .filter(e -> Objects.equals(e.getShop().getShopOwner().getId(), userId))
                .map(orderToOrderMapperDTO :: toDTO).collect(Collectors.toList());
    }

    public List<OrderDTO> getAvailableOrdersCourier(final Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new ServiceException(400, "!!!"));
        if(user.getEmployeeRole() != EmployeeRole.COURIER){
            throw new ServiceException(400, "!!!");
        }
        return orderRepository.getAvailableOrdersCourier().stream()
                .map(orderToOrderMapperDTO :: toDTO).collect(Collectors.toList());
    }

    public OrderDTO assignCourierToOrder(final Long userId, final Long orderId){
        User user = userRepository.getUserById(userId);
        Order order = orderRepository.getOrderById(orderId);

        if(user.getEmployeeRole() != EmployeeRole.COURIER){
            throw new ServiceException(400, "You are not courier!!!");
        }

        order.setStatus(Status.DELIVERING);
        order.setCourier(user);

        return orderToOrderMapperDTO.toDTO(order);
    }

    public OrderDTO updateStatusForShopOwner(final Long userId, final Long orderId){
        return null;
    }

}
