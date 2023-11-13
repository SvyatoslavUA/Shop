package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dto.OrderDTO;
import shop.entity.*;
import shop.entity.enumeration.UserRole;
import shop.entity.enumeration.Status;
import shop.exeption.ServiceException;
import shop.mapper.OrderToOrderMapperDTO;
import shop.repositiry.*;
import shop.service.OrderService;

import java.util.ArrayList;
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

    @Autowired
    private ProductRepository productRepository;



    public List<OrderDTO> getAllOrdersForCustomer(final Long userId) {
        return orderRepository.getAllOrdersForCustomer(userId).stream()
                .map(orderToOrderMapperDTO::toDTO).collect(Collectors.toList());
    }

    public List<OrderDTO> getAllOrdersForShopOwner(final Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ServiceException(400, "!!!"));
        if (user.getRole() != UserRole.SHOP_OWNER) {
            throw new ServiceException(400, "You are not shop owner!!!");
        }
        return orderRepository.getAllOrdersForCustomer(userId).stream()
                .filter(e -> Objects.equals(e.getShop().getShopOwner().getId(), userId))
                .map(orderToOrderMapperDTO::toDTO).collect(Collectors.toList());
    }

    public List<OrderDTO> getAvailableOrdersCourier(final Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ServiceException(400, "!!!"));
        if (user.getRole() != UserRole.COURIER) {
            throw new ServiceException(400, "You are not courier!!!");
        }
        return orderRepository.getAvailableOrdersCourier().stream()
                .map(orderToOrderMapperDTO::toDTO).collect(Collectors.toList());
    }

    public OrderDTO createOrderWithProduct(final List<Long> productId, final int amount, final Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ServiceException(400, "User not found!"));
        List<Product> product = productRepository.findAllById(productId).stream().toList();

        if (product.isEmpty()) {
            throw new ServiceException(400, "No products found!");
        }

        Shop shop = product.get(0).getProductsInShop().get(0).getShop();
        double totalSum = product.stream().mapToDouble(Product::getPrice).sum();

        Order order = new Order();

        List<OrderProduct> orderProducts = new ArrayList<>();

        for (Product products : product) {
            OrderProduct orderProduct = new OrderProduct();

            orderProduct.setOrder(order);
            orderProduct.setProduct(products);
            orderProduct.setAmount(amount);
            orderProducts.add(orderProduct);
        }

        order.setShop(shop);
        order.setCustomer(user);
        order.setStatus(Status.IN_PROCESSING);

        order.setOrderedProductWithAmount(orderProducts);

        order.setCustomer(user);
        order.setTotalAmount(totalSum);

        orderRepository.save(order);

        return orderToOrderMapperDTO.toDTO(order);
    }
    public OrderDTO assignCourierToOrder(final Long courierId, final Long orderId) {
        User courier = userRepository.findById(courierId).orElseThrow(() -> new ServiceException(400, "!!!"));
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new ServiceException(400, "!!!"));

        if (courier.getRole() != UserRole.COURIER) {
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
        User user = userRepository.findById(userId).orElseThrow(() -> new ServiceException(400, "User not found!!!"));

        if (!Objects.equals(orderDTO.getCustomerId(), user.getId())) {
            throw new RuntimeException("You are not the customer of this order!");
        }

        final Order savedOrder = orderRepository.findById(orderDTO.getId())
                .orElseThrow(() -> new ServiceException(400, "Order with id not found: " + orderDTO.getId(), ""));

        savedOrder.setShippingAddress(orderDTO.getShippingAddress());

        return orderToOrderMapperDTO.toDTO(orderRepository.save(savedOrder));
    }

    public OrderDTO updateStatusForOwner(Long orderId, Long userId, Status status) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ServiceException(400, "User not found!!!"));
        if (user.getRole() != UserRole.SHOP_OWNER) {
            throw new ServiceException(400, "You are not shop owner!!!");
        }

        final Order savedOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new ServiceException(400, "Order with id not found: " + orderId, ""));

        if(status != Status.IN_PROCESSING && status != Status.READY_TO_DELIVER){
            throw new RuntimeException("Status must be IN_PROCESSING or READY_TO_DELIVER!");
        }

        savedOrder.setStatus(status);
        orderRepository.save(savedOrder);

        return orderToOrderMapperDTO.toDTO(savedOrder);
    }

    public OrderDTO completeOrder(Long orderId, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ServiceException(400, "User not found!!!"));
        if (user.getRole() != UserRole.COURIER) {
            throw new ServiceException(400, "You are not courier!!!");
        }

        final Order savedOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new ServiceException(400, "Order with id not found: " + orderId, ""));

        savedOrder.setStatus(Status.COMPLETED);
        orderRepository.save(savedOrder);

        return orderToOrderMapperDTO.toDTO(savedOrder);
    }
}
