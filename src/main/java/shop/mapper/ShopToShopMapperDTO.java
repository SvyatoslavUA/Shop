package shop.mapper;

import org.springframework.stereotype.Component;
import shop.dto.ShopDTO;
import shop.entity.Shop;

@Component
public class ShopToShopMapperDTO {
    public Shop toEntity(final ShopDTO shopDTO){
        final Shop shop = new Shop();

        shop.setShopName(shopDTO.getShopName());
        shop.setId(shopDTO.getId());
        shop.setAddress(shopDTO.getAddress());
        shop.setWorkingDays(shopDTO.getWorkingDays());
        shop.setWorkingHours(shopDTO.getWorkingHours());
        shop.setShopOwner(shopDTO.getShopOwner());

        return shop;
    }

    public ShopDTO toDTO(final Shop shop){
        final ShopDTO shopDTO = new ShopDTO();

        shopDTO.setShopName(shop.getShopName());
        shopDTO.setAddress(shop.getAddress());
        shopDTO.setId(shop.getId());
        shopDTO.setWorkingDays(shop.getWorkingDays());
        shopDTO.setWorkingHours(shop.getWorkingHours());
        shopDTO.setShopOwner(shop.getShopOwner());

        return shopDTO;
    }
}
