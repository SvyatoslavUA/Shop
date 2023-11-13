package shop.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopProductDTO {
    private Long id;

//    @NotNull
    private Long product;

//    @NotNull
    private Long shop;

//    @NotNull
//    @NotBlank
    private boolean availableForOrdering;
}
