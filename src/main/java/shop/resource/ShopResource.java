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
    public ShopDTO getShopForOwner(@PathVariable Long userId, String password) {
        return shopService.getShopForOwner(userId, password);
    }

    @PutMapping("/save")
    public ShopDTO saveShop(final ShopDTO shopDTO) {
        return shopService.saveShop(shopDTO);
    }

    @PutMapping("/update/{password}")
    public ShopDTO updateShopInformation(@RequestBody ShopDTO shopDTO, @PathVariable String password) {
        return shopService.updateShopInformation(shopDTO, password);
    }
}
