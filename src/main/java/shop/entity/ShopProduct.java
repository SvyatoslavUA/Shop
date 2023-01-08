package shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopProduct {
    private Product productId;
    private Shop shopId;
    private boolean availableForOrdering;
}
