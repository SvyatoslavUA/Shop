package shop.mapper;

import org.springframework.stereotype.Component;
import shop.dto.ShopDTO;
import shop.entity.Shop;

@Component
public class ShopToShopMapperDTO {
    public Shop toEntity(final ShopDTO shopDTO){
        final Shop shop = new Shop();

        shop.setName(shopDTO.getName());
        shop.setId(shopDTO.getId());
        shop.setAddress(shopDTO.getAddress());
        shop.setWorkingDays(shopDTO.getWorkingDays());
        shop.setWorkingHoursStart(shopDTO.getWorkingHoursStart());
        shop.setWorkingHoursEnd(shopDTO.getWorkingHoursEnd());

        return shop;
    }

    public ShopDTO toDTO(final Shop shop){
        final ShopDTO shopDTO = new ShopDTO();

        shopDTO.setName(shop.getName());
        shopDTO.setAddress(shop.getAddress());
        shopDTO.setId(shop.getId());
        shopDTO.setWorkingDays(shop.getWorkingDays());
        shopDTO.setWorkingHoursStart(shop.getWorkingHoursStart());
        shopDTO.setWorkingHoursEnd(shop.getWorkingHoursEnd());
        shopDTO.setShopOwner(shopDTO.getShopOwner());

        return shopDTO;
    }
}
