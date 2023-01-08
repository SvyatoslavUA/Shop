package shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.entity.enumeration.Status;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order {
    private Long id;
    private User customerId;
    private List<OrderProduct> orderedProductWithAmount;
    private Shop shopId;
    private User courierId;
    private String shippingAddress;
    private double totalAmount;
    private Status status;
}
