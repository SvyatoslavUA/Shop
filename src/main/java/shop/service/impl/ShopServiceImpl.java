package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dto.ShopDTO;
import shop.dto.UserDTO;
import shop.entity.Order;
import shop.entity.Shop;
import shop.entity.User;
import shop.exeption.ServiceException;
import shop.mapper.ShopToShopMapperDTO;
import shop.repositiry.ShopRepository;
import shop.repositiry.UserRepository;
import shop.service.ShopService;

import java.util.Objects;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ShopToShopMapperDTO shopToShopMapperDTO;

    @Autowired
    private UserRepository userRepository;



    public ShopDTO getShopForOwner(UserDTO userDTO) {
        Shop shop = shopRepository.findAll().stream().filter(e -> e.getShopOwner().getId() == userDTO.getId()).findFirst().get();
        return shopToShopMapperDTO.toDTO(shop);
    }

    public ShopDTO updateShopInformation(ShopDTO shopDTO, Long userId){
        User user = userRepository.getUserById(userId);

        if(!Objects.equals(shopDTO.getShopOwner().getId(), user.getId())){
            throw new RuntimeException("You are not the owner of this store!");
        }
        final Shop savedShop = shopRepository.findById(shopDTO.getId())
                .orElseThrow(() -> new ServiceException(400, "Shop with id not found: " + shopDTO.getId(), ""));

        savedShop.setShopName(shopDTO.getShopName());
        savedShop.setShopName();
        savedShop.setShopName();
        savedShop.setShopName();
        return shopToShopMapperDTO.toDTO(shopRepository.save(savedShop));
    }
}
