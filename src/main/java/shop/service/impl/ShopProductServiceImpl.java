package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dto.ShopProductDTO;
import shop.entity.Product;
import shop.entity.Shop;
import shop.entity.ShopProduct;
import shop.exeption.ServiceException;
import shop.mapper.ShopProductToShopProductMapperDTO;
import shop.repositiry.ProductRepository;
import shop.repositiry.ShopProductRepository;
import shop.repositiry.ShopRepository;
import shop.service.ShopProductService;

@Service
public class ShopProductServiceImpl implements ShopProductService {
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ShopProductRepository shopProductRepository;
    @Autowired
    private ShopProductToShopProductMapperDTO shopProductToShopProductMapperDTO;

    public ShopProductDTO enableSelling(Long shopId, Long productId) {
       return setAvailabilitySelling(shopId, productId, true);
    }

    public ShopProductDTO disableSelling(Long shopId, Long productId) {
        return setAvailabilitySelling(shopId, productId, false);
    }

    private ShopProductDTO setAvailabilitySelling(Long shopId, Long productId, boolean availability) {
        Shop shop = shopRepository
                .findById(shopId).orElseThrow(() -> new ServiceException(400, "Shop with id not found: " + shopId, ""));
        Product product = productRepository
                .findById(productId).orElseThrow(() -> new ServiceException(400, "Product with id not found: " + productId, ""));

        ShopProduct shopProduct = shopProductRepository.getShopProductByProductIdAndShopId(productId, shopId);

        if (shopProduct == null) {
            shopProduct = new ShopProduct();
            shopProduct.setShop(shop);
            shopProduct.setProduct(product);
            shopProduct.setAvailableForOrdering(availability);

            shop.getShopHasProducts().add(shopProduct);
            product.getProductsInShop().add(shopProduct);

            shopRepository.save(shop);
            productRepository.save(product);
        } else {
            shopProduct.setAvailableForOrdering(availability);
        }

        shopProductRepository.save(shopProduct);

        return shopProductToShopProductMapperDTO.toDTO(shopProduct);
    }
}
