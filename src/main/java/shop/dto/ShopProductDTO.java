package shop.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.entity.Product;
import shop.entity.Shop;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopProductDTO {

//    @NotNull
    private Product productId;

//    @NotNull
    private Shop shopId;

//    @NotNull
//    @NotBlank
    private boolean availableForOrdering;
}
