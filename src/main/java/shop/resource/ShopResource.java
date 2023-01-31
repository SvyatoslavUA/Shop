package shop.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.dto.ShopDTO;
import shop.service.ShopService;

@RestController
@RequestMapping("/api/v1/shop")
public class ShopResource {
    @Autowired
    private ShopService shopService;

    @GetMapping("/shop-owner")
    public ShopDTO getShopForOwner(@PathVariable Long userId) {
        return shopService.getShopForOwner(userId);
    }

    @PutMapping("/save")
    public ShopDTO saveShop(final ShopDTO shopDTO) {
        return shopService.saveShop(shopDTO);
    }

    @PutMapping("/update/{password}")
    public ShopDTO updateShopInformation(@RequestBody ShopDTO shopDTO) {
        return shopService.updateShopInformation(shopDTO);
    }
}
