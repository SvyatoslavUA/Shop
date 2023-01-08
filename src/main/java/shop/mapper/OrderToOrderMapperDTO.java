package shop.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shop.dto.OrderDTO;
import shop.dto.OrderProductDTO;
import shop.entity.Order;
import shop.entity.OrderProduct;
import shop.repositiry.OrderProductRepository;

import java.util.Arrays;
import java.util.stream.Collectors;


@Component
public class OrderToOrderMapperDTO {

    @Autowired
    private OrderProductToOrderProductMapperDTO orderProductToOrderProductMapperDTO;
    @Autowired
    private OrderProductRepository orderProductRepository;

    public void order(final OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }


//    public Order toEntity(final OrderDTO orderDTO){
//        final Order order = new Order();
//
//        order.setCourierId(orderDTO.getCourierId());
////        order.setOrderedProductWithAmount(orderProductRepository.findAllByIdIn(orderDTO.getOrderedProductWithAmount()));
//        order.setId(orderDTO.getId());
//        order.setStatus(orderDTO.getStatus());
//        order.setShippingAddress(orderDTO.getShippingAddress());
//        order.setCustomerId(orderDTO.getCustomerId());
//        order.setShopId(orderDTO.getShopId());
//        order.setTotalAmount(orderDTO.getTotalAmount());
//
//        return order;
//    }

    public OrderDTO toDTO(final Order order){
        final OrderDTO orderDTO = new OrderDTO();

        orderDTO.setTotalAmount(order.getTotalAmount());
        orderDTO.setCourierId(order.getCourierId());
        orderDTO.setId(order.getId());

        orderDTO.setOrderedProductWithAmount(orderProductToOrderProductMapperDTO.toDTO(order.getOrderedProductWithAmount()));
        orderDTO.setCustomerId(order.getCustomerId());
        orderDTO.setShippingAddress(order.getShippingAddress());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setShopId(order.getShopId());

        return orderDTO;
    }
}
