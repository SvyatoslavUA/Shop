package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dto.ShopDTO;
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

    public ShopDTO getShopForOwner(final Long userId, final String password) {
        User user = userRepository.getUserById(userId);

        if (!Objects.equals(user.getShop().getShopOwner().getPassword(), password)) {
            throw new RuntimeException("Password is wrong!");
        }

        return shopToShopMapperDTO.toDTO(shopRepository.getShopForShopOwner(userId));
    }

    public ShopDTO saveShop(final ShopDTO shopDTO) {
        User user = userRepository.getUserById(shopDTO.getShopOwner().getId());

        final Shop savedShop = shopRepository.findById(shopDTO.getId())
                .orElseThrow(() -> new ServiceException(400, "Shop with id not found: " + shopDTO.getId(), ""));

        if (!Objects.equals(shopDTO.getShopOwner().getId(), user.getId())) {
            throw new RuntimeException("You are not the owner of this store!");
        }

        final Shop shop = shopToShopMapperDTO.toEntity(shopDTO);
        shopRepository.save(shop);

        return shopToShopMapperDTO.toDTO(shop);
    }

    public ShopDTO updateShopInformation(ShopDTO shopDTO, String password) {
        final Shop savedShop = shopRepository.findById(shopDTO.getId())
                .orElseThrow(() -> new ServiceException(400, "Shop with id not found: " + shopDTO.getId(), ""));

        if (!Objects.equals(shopDTO.getShopOwner().getPassword(), password)) {
            throw new RuntimeException("Password is wrong!");
        }

        savedShop.setShopName(shopDTO.getShopName());
        savedShop.setWorkingHours(shopDTO.getWorkingHours());
        savedShop.setWorkingDays(shopDTO.getWorkingDays());
        savedShop.setAddress(shopDTO.getAddress());

        return shopToShopMapperDTO.toDTO(shopRepository.save(savedShop));
    }
}
