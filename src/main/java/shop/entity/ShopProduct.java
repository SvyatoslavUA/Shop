package shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopProduct {
    private Long productId;
    private Long shopId;
    private boolean availableForOrdering;
}
