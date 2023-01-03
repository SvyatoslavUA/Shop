package shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.entity.enumeration.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order {
    private Long id;
    private int customerId;
    private String orderedProductWithAmount;
    private Long shopId;
    private Long courierId;
    private String shippingAddress;
    private double totalAmount;
    private Status status;
}
