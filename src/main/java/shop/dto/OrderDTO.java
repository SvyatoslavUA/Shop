package shop.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.entity.enumeration.Status;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;

    private Long customerId;

    private List<OrderProductDTO> orderedProductWithAmount;

//    @NotNull
    private Long shopId;

//    @NotNull
    private Long courierId;

//    @NotNull
    private String shippingAddress;

//    @Min(1)
    private double totalAmount;

//    @NotNull
    private Status status;
}
