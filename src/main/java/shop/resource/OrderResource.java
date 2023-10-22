package shop.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.dto.AssignmentDTO;
import shop.dto.OrderDTO;
import shop.entity.enumeration.Status;
import shop.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderResource {
    @Autowired
    private OrderService orderService;

    @PutMapping("/customer/create-order/{productId}/{amount}/{userId}")
    public OrderDTO createOrderWithProduct(@PathVariable List<Long> productId, @PathVariable int amount, @PathVariable Long userId){
        return orderService.createOrderWithProduct(productId, amount, userId);
    }

    @GetMapping("/customer/{userId}")
    public List<OrderDTO> getAllOrdersForCustomer(@PathVariable final Long userId) {
        return orderService.getAllOrdersForCustomer(userId);
    }

    @GetMapping("/shop-owner/{userId}")
    public List<OrderDTO> getAllOrdersForShopOwner(@PathVariable final Long userId) {
        return orderService.getAllOrdersForShopOwner(userId);
    }

    @GetMapping("/courier/{userId}")
    public List<OrderDTO> getAvailableOrdersCourier(@PathVariable final Long userId) {
        return orderService.getAvailableOrdersCourier(userId);
    }

    @PutMapping("/assign")
    public OrderDTO assignCourierToOrder(@RequestBody AssignmentDTO assignmentDTO) {
        return orderService.assignCourierToOrder(assignmentDTO.getCourierId(), assignmentDTO.getOrderId());
    }

    @PutMapping("/update-order-customer/{userId}/{orderDTO}")
    public OrderDTO updateOrderInformation(@PathVariable final OrderDTO orderDTO, @PathVariable final Long userId){
        return orderService.updateOrderInformation(orderDTO, userId);
    }

    @PutMapping("/update-status-owner/{orderId}/{userId}/{status}")
    public OrderDTO updateStatusForOwner(@PathVariable final Long orderId, @PathVariable final Long userId, @PathVariable Status status){
        return orderService.updateStatusForOwner(orderId, userId, status);
    }

    @PutMapping("/complete-order-courier/{orderId}/{userId}")
    public OrderDTO completeOrder(@PathVariable final Long orderId, @PathVariable final Long userId){
        return orderService.completeOrder(orderId, userId);
    }
}
