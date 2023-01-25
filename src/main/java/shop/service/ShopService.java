package shop.service;

import shop.dto.ShopDTO;

public interface ShopService {
    ShopDTO getShopForOwner(Long userId, String password);

    ShopDTO saveShop(final ShopDTO shopDTO);

    ShopDTO updateShopInformation(ShopDTO shopDTO, String password);
}
