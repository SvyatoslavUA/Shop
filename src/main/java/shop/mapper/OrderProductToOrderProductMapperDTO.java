package shop.mapper;

import org.springframework.stereotype.Component;
import shop.dto.OrderProductDTO;
import shop.entity.OrderProduct;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderProductToOrderProductMapperDTO {

    public OrderProduct toEntity(final OrderProductDTO orderProductDTO){
        final OrderProduct orderProduct = new OrderProduct();

        orderProduct.setOrderId(orderProductDTO.getOrderId());
        orderProduct.setProductId(orderProductDTO.getProductId());
        orderProduct.setAmount(orderProductDTO.getAmount());

        return orderProduct;
    }

    public OrderProductDTO toDTO(final OrderProduct orderProduct){

        final OrderProductDTO orderProductDTO = new OrderProductDTO();

        orderProductDTO.setProductId(orderProduct.getProductId());
        orderProductDTO.setOrderId(orderProduct.getOrderId());
        orderProductDTO.setAmount(orderProduct.getAmount());

        return orderProductDTO;
    }
    public List <OrderProductDTO> toDTO(final List<OrderProduct> orderProduct){



        return orderProduct.stream().map(e -> this.toDTO(e)).collect(Collectors.toList());
    }
}
