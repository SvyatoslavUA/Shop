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
    private Long Id;
//    @NotNull
    private Long orderId;

//    @NotNull
    private Long productId;

//    @NotBlank
//    @Min(1)
    private int amount;
}
