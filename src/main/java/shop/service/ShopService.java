package shop.service;
import shop.dto.ShopDTO;
import shop.dto.UserDTO;

import java.util.List;

public interface ShopService {
    ShopDTO getShopForOwner(UserDTO userDTO);
    ShopDTO updateShopInformation(ShopDTO shopDTO, Long userId);
}
