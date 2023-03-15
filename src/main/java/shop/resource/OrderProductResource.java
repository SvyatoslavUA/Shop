package shop.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.dto.OrderProductDTO;
import shop.service.OrderProductService;

@RestController
@RequestMapping("/api/v1/order-product")
public class OrderProductResource {
    @Autowired
    private OrderProductService orderProductService;

    @PutMapping("/amount")
    public OrderProductDTO setAmount(@RequestBody OrderProductDTO orderProductDTO) {
        return orderProductService.setAmount(orderProductDTO);
    }

    @DeleteMapping("/delete/{orderProductId}")
    public ResponseEntity delete(@PathVariable final Long orderProductId){
        orderProductService.delete(orderProductId);
        return ResponseEntity.ok().build();
    }
}

