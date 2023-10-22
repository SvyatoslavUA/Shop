package shop.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shop.dto.ShopProductDTO;
import shop.entity.ShopProduct;


@Component
public class ShopProductToShopProductMapperDTO {
    @Autowired
    private  ProductToProductMapperDTO productToProductMapperDTO;

    @Autowired
    private ShopToShopMapperDTO shopToShopMapperDTO;

    public ShopProduct toEntity(final ShopProductDTO shopProductDTO){
        final ShopProduct shopProduct = new ShopProduct();

      //  shopProduct.setProduct(shopProductDTO.getProductId());
      //  shopProduct.setShop(shopProductDTO.getShopId());
        shopProduct.setAvailableForOrdering(shopProductDTO.isAvailableForOrdering());

        return shopProduct;
    }

    public ShopProductDTO toDTO(final ShopProduct shopProduct){
        final ShopProductDTO shopProductDTO = new ShopProductDTO();

        shopProductDTO.setShop(shopProduct.getShop().getId());
        shopProductDTO.setProduct(shopProduct.getProduct().getId());
        shopProductDTO.setAvailableForOrdering(shopProduct.isAvailableForOrdering());

        return shopProductDTO;
    }
}
