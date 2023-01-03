package shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.entity.enumeration.Status;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductDTO {
    private Long id;

    private int customerId;
    private String orderedProductWithAmount;
    private Long shopId;
    private Long courierId;
    private String shippingAddress;
    private double totalAmount;
    private Status status;
}
