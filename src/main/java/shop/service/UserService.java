package shop.service;

import shop.dto.UserDTO;

public interface UserService {
    UserDTO getUser(Long userId, String password);
    UserDTO saveUser(UserDTO user);
    UserDTO updateUserInformation(Long userId, String password);
}
