package shop.service;

import shop.dto.ShopProductDTO;

public interface ShopProductService {
    ShopProductDTO enableSelling(Long shopId, Long productId);
    ShopProductDTO disableSelling(Long shopId, Long productId);
}
