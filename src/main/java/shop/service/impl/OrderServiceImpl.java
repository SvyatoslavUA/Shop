package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dto.OrderDTO;
import shop.dto.UserDTO;
import shop.entity.User;
import shop.entity.enumeration.EmployeeRole;
import shop.mapper.OrderToOrderMapperDTO;
import shop.repositiry.OrderRepository;
import shop.repositiry.UserRepository;
import shop.service.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private final OrderToOrderMapperDTO orderMapper;

    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final UserRepository userRepository;

    public OrderServiceImpl(final OrderRepository orderRepository, final OrderToOrderMapperDTO orderMapper, final UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.userRepository = userRepository;
    }

    public List<OrderDTO> getAllOrdersForCustomer(final UserDTO userDTO){
        return orderRepository.findAll().stream().filter(e -> userDTO.getEmployeeRole() == EmployeeRole.CUSTOMER).filter(e -> e.getCustomerId().getId() == userDTO.getId()).map(orderMapper :: toDTO).collect(Collectors.toList());
    }
}
