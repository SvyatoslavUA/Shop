package shop.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopProductDTO {

//    @NotNull
    private Long productId;

//    @NotNull
    private Long shopId;

//    @NotNull
//    @NotBlank
    private boolean availableForOrdering;
}
