package shop.service;
import shop.dto.ShopDTO;

import java.util.List;

public interface ShopService {
    ShopDTO getShopForOwner(Long id);
    ShopDTO updateShopInformation(ShopDTO shopDTO);
}
