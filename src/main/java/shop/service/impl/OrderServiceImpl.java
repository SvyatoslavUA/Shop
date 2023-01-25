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


    public List<OrderDTO> getAllOrdersForCustomer(final Long userId) {
        return orderRepository.getAllOrdersForCustomer(userId).stream()
                .map(orderToOrderMapperDTO::toDTO).collect(Collectors.toList());
    }

    public List<OrderDTO> getAllOrdersForShopOwner(final Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ServiceException(400, "!!!"));
        if (user.getEmployeeRole() != EmployeeRole.SHOP_OWNER) {
            throw new ServiceException(400, "!!!");
        }
        return orderRepository.getAllOrdersForCustomer(userId).stream()
                .filter(e -> Objects.equals(e.getShop().getShopOwner().getId(), userId))
                .map(orderToOrderMapperDTO::toDTO).collect(Collectors.toList());
    }

    public List<OrderDTO> getAvailableOrdersCourier(final Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ServiceException(400, "!!!"));
        if (user.getEmployeeRole() != EmployeeRole.COURIER) {
            throw new ServiceException(400, "!!!");
        }
        return orderRepository.getAvailableOrdersCourier().stream()
                .map(orderToOrderMapperDTO::toDTO).collect(Collectors.toList());
    }

    public OrderDTO assignCourierToOrder(final Long userId, final Long orderId) {
        User courier = userRepository.getUserById(userId);
        Order order = orderRepository.getOrderById(orderId);

        if (courier.getEmployeeRole() != EmployeeRole.COURIER) {
            throw new ServiceException(400, "You are not courier!!!");
        }

        if (order.getStatus() != Status.READY_TO_DELIVER) {
            throw new ServiceException(400, "Status is not ready to deliver!!!");
        }

        order.setStatus(Status.DELIVERING);
        order.setCourier(courier);
        courier.getDelivered().add(order);

        orderRepository.save(order);
        userRepository.save(courier);

        return orderToOrderMapperDTO.toDTO(order);
    }

    public OrderDTO updateOrderInformation(OrderDTO orderDTO, Long userId) {
        User user = userRepository.getUserById(userId);

        if (!Objects.equals(orderDTO.getCustomerId().getId(), user.getId())) {
            throw new RuntimeException("You are not the customer of this order!");
        }

        final Order savedOrder = orderRepository.findById(orderDTO.getId())
                .orElseThrow(() -> new ServiceException(400, "Order with id not found: " + orderDTO.getId(), ""));

        savedOrder.setShippingAddress(orderDTO.getShippingAddress());

        return orderToOrderMapperDTO.toDTO(orderRepository.save(savedOrder));
    }

}
