package shop.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dto.ShopOwnerCreateDTO;
import shop.dto.UserDTO;
import shop.entity.Shop;
import shop.entity.User;
import shop.exeption.ServiceException;
import shop.mapper.UserToUserMapperDTO;
import shop.repositiry.ShopRepository;
import shop.repositiry.UserRepository;
import shop.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserToUserMapperDTO userToUserMapperDTO;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShopRepository shopRepository;

    public UserDTO getUser(Long userId) {
        return userToUserMapperDTO.toDTO(userRepository.findById(userId)
                .orElseThrow(() -> new ServiceException(400, "User with id not found: " + userId, "")));
    }

    public UserDTO saveUser(final UserDTO userDTO) {

        final User user = userToUserMapperDTO.toEntity(userDTO);

        userRepository.save(user);

        return userToUserMapperDTO.toDTO(user);
    }

    public UserDTO createShopOwnerAndShop(final ShopOwnerCreateDTO shopOwnerCreateDTO) {
        final User user = new User();
        final Shop shop = new Shop();

        user.setShop(shop);
        shop.setShopOwner(user);

        shopRepository.save(shop);
        userRepository.save(user);

        return userToUserMapperDTO.toDTO(user);
    }

    public UserDTO updateUserInformation(UserDTO userDTO){
        final User savedUser = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new ServiceException(400, "User with id not found: " + userDTO.getId(), ""));

        savedUser.setPassword(userDTO.getPassword());
        savedUser.setSurname(userDTO.getSurname());
        savedUser.setName(userDTO.getName());

        return userToUserMapperDTO.toDTO(userRepository.save(savedUser));
    }
}
