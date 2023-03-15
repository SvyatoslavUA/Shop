package shop.service;

import shop.dto.ShopOwnerCreateDTO;
import shop.dto.UserDTO;

public interface UserService {
    UserDTO getUser(Long userId);
    UserDTO saveUser(UserDTO user);
    UserDTO createShopOwnerAndShop(ShopOwnerCreateDTO shopOwnerCreateDTO);
    UserDTO updateUserInformation(UserDTO userDTO);
}
