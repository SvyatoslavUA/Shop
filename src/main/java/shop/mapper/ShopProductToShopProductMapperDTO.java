package shop.mapper;

import org.springframework.stereotype.Component;
import shop.dto.ShopProductDTO;
import shop.entity.ShopProduct;

@Component
public class ShopProductToShopProductMapperDTO {
    public ShopProduct toEntity(final ShopProductDTO shopProductDTO){
        final ShopProduct shopProduct = new ShopProduct();

        shopProduct.setProductId(shopProductDTO.getProductId());
        shopProduct.setShopId(shopProductDTO.getShopId());
        shopProduct.setAvailableForOrdering(shopProductDTO.isAvailableForOrdering());

        return shopProduct;
    }

    public ShopProductDTO toDTO(final ShopProduct shopProduct){
        final ShopProductDTO shopProductDTO = new ShopProductDTO();

        shopProductDTO.setShopId(shopProduct.getShopId());
        shopProductDTO.setProductId(shopProduct.getProductId());
        shopProductDTO.setAvailableForOrdering(shopProduct.isAvailableForOrdering());

        return shopProductDTO;
    }
}
