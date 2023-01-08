package shop.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.entity.Product;
import shop.entity.Shop;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopProductDTO {
    @Id
    @NotNull
    private Product productId;

    @Id
    @NotNull
    private Shop shopId;

    @NotNull
    @NotBlank
    private boolean availableForOrdering;
}
