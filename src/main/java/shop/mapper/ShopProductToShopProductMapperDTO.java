package shop.mapper;

import org.springframework.stereotype.Component;
import shop.dto.ShopProductDTO;
import shop.entity.ShopProduct;

@Component
public class ShopProductToShopProductMapperDTO {
    public ShopProduct toEntity(final ShopProductDTO shopProductDTO){
        final ShopProduct shopProduct = new ShopProduct();

//        shopProduct.setProduct(shopProductDTO.getProductId());
//        shopProduct.setShop(shopProductDTO.getShopId());
        shopProduct.setAvailableForOrdering(shopProductDTO.isAvailableForOrdering());

        return shopProduct;
    }

    public ShopProductDTO toDTO(final ShopProduct shopProduct){
        final ShopProductDTO shopProductDTO = new ShopProductDTO();

//        shopProductDTO.setShopId(shopProduct.getShop());
//        shopProductDTO.setProductId(shopProduct.getProduct());
        shopProductDTO.setAvailableForOrdering(shopProduct.isAvailableForOrdering());

        return shopProductDTO;
    }
}
