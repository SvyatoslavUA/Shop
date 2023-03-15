package shop.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shop.dto.OrderDTO;
import shop.entity.Order;
import shop.repositiry.OrderProductRepository;


@Component
public class OrderToOrderMapperDTO {

    @Autowired
    private OrderProductToOrderProductMapperDTO orderProductToOrderProductMapperDTO;
    @Autowired
    private OrderProductRepository orderProductRepository;

    public void order(final OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }


    public Order toEntity(final OrderDTO orderDTO){
        final Order order = new Order();

        order.setShippingAddress(orderDTO.getShippingAddress());

        return order;
    }

    public OrderDTO toDTO(final Order order){
        final OrderDTO orderDTO = new OrderDTO();

        orderDTO.setTotalAmount(order.getTotalAmount());
        orderDTO.setCourierId(order.getCourier().getId());
        orderDTO.setId(order.getId());

        orderDTO.setOrderedProductWithAmount(orderProductToOrderProductMapperDTO.toDTO(order.getOrderedProductWithAmount()));
        orderDTO.setCustomerId(order.getCustomer().getId());
        orderDTO.setShippingAddress(order.getShippingAddress());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setShopId(order.getShop().getId());

        return orderDTO;
    }
}
