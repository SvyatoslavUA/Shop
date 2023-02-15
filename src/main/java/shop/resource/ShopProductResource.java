package shop.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.dto.ShopProductDTO;
import shop.service.ShopProductService;

@RestController
@RequestMapping("/api/v1/shop-product")
public class ShopProductResource {
    @Autowired
    private ShopProductService shopProductService;

    @PutMapping("/enable/{shopId}/{productId}")
    public ShopProductDTO enableSelling(Long shopId, Long productId) {
        return shopProductService.enableSelling(shopId, productId);
    }

    @PutMapping("/disable/{shopId}/{productId}")
    public ShopProductDTO disableSelling(Long shopId, Long productId) {
        return shopProductService.disableSelling(shopId, productId);
    }
}
