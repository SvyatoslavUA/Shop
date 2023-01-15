package shop.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.entity.Shop;
import shop.entity.User;
import shop.entity.enumeration.Status;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;

//    @NotNull
    private User customerId;

    //    @NotNull
    private List<OrderProductDTO> orderedProductWithAmount;

//    @NotNull
    private Shop shopId;

//    @NotNull
    private User courierId;

//    @NotNull
    private String shippingAddress;

//    @Min(1)
    private double totalAmount;

//    @NotNull
    private Status status;
}
