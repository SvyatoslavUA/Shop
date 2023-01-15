package shop.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.dto.OrderDTO;
import shop.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderResource {
    @Autowired
    private OrderService orderService;


    @GetMapping("/allOrdersForCustomer/{id}")
    public List<OrderDTO> getAllOrdersForCustomer(@PathVariable final Long userId) {
        return orderService.getAllOrdersForCustomer(userId);
    }

    @GetMapping("/allOrdersForShopOwner/{id}")
    public List<OrderDTO> getAllOrdersForShopOwner(@PathVariable final Long userId) {
        return orderService.getAllOrdersForShopOwner(userId);
    }

    @GetMapping("/allOrdersForShopOwner/{id}")
    public List<OrderDTO> getAvailableOrdersCourier(@PathVariable final Long userId) {
        return orderService.getAvailableOrdersCourier(userId);
    }

    @PutMapping("/assignCourierToOrder/{id}/{id}")
    public OrderDTO assignCourierToOrder(@PathVariable final Long userId, @PathVariable final Long orderId) {
        return orderService.assignCourierToOrder(userId, orderId);
    }
}
