package shop.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dto.ShopDTO;
import shop.entity.Shop;
import shop.exeption.ServiceException;
import shop.mapper.ShopToShopMapperDTO;
import shop.repositiry.ShopRepository;
import shop.repositiry.UserRepository;
import shop.service.ShopService;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ShopToShopMapperDTO shopToShopMapperDTO;

    @Autowired
    private UserRepository userRepository;

    public ShopDTO getShopForOwner(final Long userId) {
        return shopToShopMapperDTO.toDTO(shopRepository.getShopForShopOwner(userId));
    }

    public ShopDTO saveShop(final ShopDTO shopDTO) {
        final Shop shop = shopToShopMapperDTO.toEntity(shopDTO);

        shopRepository.save(shop);

        return shopToShopMapperDTO.toDTO(shop);
    }

    public ShopDTO updateShopInformation(ShopDTO shopDTO) {
        final Shop savedShop = shopRepository.findById(shopDTO.getId())
                .orElseThrow(() -> new ServiceException(400, "Shop with id not found: " + shopDTO.getId(), ""));

        savedShop.setName(shopDTO.getName());
        savedShop.setWorkingHours(shopDTO.getWorkingHours());
        savedShop.setWorkingDays(shopDTO.getWorkingDays());
        savedShop.setAddress(shopDTO.getAddress());

        return shopToShopMapperDTO.toDTO(shopRepository.save(savedShop));
    }
}
