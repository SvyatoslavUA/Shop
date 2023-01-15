package shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.entity.Order;
import shop.entity.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductDTO {
//    @NotNull
    private Order orderId;

//    @NotNull
    private Product productId;

//    @NotBlank
//    @Min(1)
    private int amount;
}
