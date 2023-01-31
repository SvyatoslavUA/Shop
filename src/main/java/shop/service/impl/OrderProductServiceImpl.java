package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dto.OrderProductDTO;
import shop.entity.Order;
import shop.entity.OrderProduct;
import shop.entity.Product;
import shop.exeption.ServiceException;
import shop.mapper.OrderProductToOrderProductMapperDTO;
import shop.repositiry.OrderProductRepository;
import shop.repositiry.OrderRepository;
import shop.repositiry.ProductRepository;
import shop.service.OrderProductService;

@Service
public class OrderProductServiceImpl implements OrderProductService {
    @Autowired
    private OrderProductRepository orderProductRepository;
    @Autowired
    private OrderProductToOrderProductMapperDTO orderProductToOrderProductMapperDTO;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    public OrderProductDTO setAmount(OrderProductDTO orderProductDTO) {
        OrderProduct orderProduct = orderProductRepository.findById(orderProductDTO.getId()).orElse(null);

        final Order order = orderRepository.findById(orderProductDTO.getOrderId())
                .orElseThrow(() -> new ServiceException(400, "Order with id not found: " + orderProductDTO.getOrderId(), "create new one!"));

        final Product product = productRepository.findById(orderProductDTO.getProductId())
                .orElseThrow(() -> new ServiceException(400, "Product with id not found: " + orderProductDTO.getProductId(), ""));

        if (orderProduct == null) {
            orderProduct = new OrderProduct();
            orderProduct.setOrder(order);
            orderProduct.setProduct(product);

            order.getOrderedProductWithAmount().add(orderProduct);
            product.getProductsInOrder().add(orderProduct);

            orderRepository.save(order);
            productRepository.save(product);
        } else {
            orderProduct.setAmount(orderProductDTO.getAmount());
        }

        orderProductRepository.save(orderProduct);

        return orderProductToOrderProductMapperDTO.toDTO(orderProduct);
    }

    public void delete(Long id) {
        orderProductRepository.deleteById(id);
    }
}
