package shop.service;

import shop.dto.ShopDTO;

import java.util.List;

public interface ShopService {
    ShopDTO getShopForOwner(final Long userId);
    ShopDTO saveShop(final ShopDTO shopDTO);
    ShopDTO updateShopInformation(ShopDTO shopDTO);
    List<ShopDTO> findOpenedShops();
}
