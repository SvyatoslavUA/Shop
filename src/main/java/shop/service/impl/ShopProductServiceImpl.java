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

    public ShopProductDTO enableSelling(Long shopId, Long productId){
        Shop shop = shopRepository
                .findById(shopId).orElseThrow(() -> new ServiceException(400, "Shop with id not found: " + shopId, ""));
        Product product = productRepository
                .findById(productId).orElseThrow(() -> new ServiceException(400, "Product with id not found: " + productId, ""));

        ShopProduct shopProduct = shopProductRepository.getShopProductByProductId(productId);

        if(shopProduct.isAvailableForOrdering()){
            throw new RuntimeException("Product already enabled!");
        }

        if (shopProduct == null) {
            shopProduct = new ShopProduct();
            shopProduct.setShop(shop);
            shopProduct.setProduct(product);
            shopProduct.setAvailableForOrdering(true);

            shop.getShopHasProducts().add(shopProduct);
            product.getProductsInShop().add(shopProduct);

            shopRepository.save(shop);
            productRepository.save(product);
        } else {
            shopProduct.setAvailableForOrdering(true);
        }

        shopProductRepository.save(shopProduct);

        return shopProductToShopProductMapperDTO.toDTO(shopProduct);
    }
    public ShopProductDTO disableSelling(Long shopId, Long productId){
        Shop shop = shopRepository
                .findById(shopId).orElseThrow(() -> new ServiceException(400, "Shop with id not found: " + shopId, ""));
        Product product = productRepository
                .findById(productId).orElseThrow(() -> new ServiceException(400, "Product with id not found: " + productId, ""));

        ShopProduct shopProduct = shopProductRepository.getShopProductByProductId(productId);

        if(shopProduct.isAvailableForOrdering()){
            throw new RuntimeException("Product already disabled!");
        }

        if (shopProduct == null) {
            shopProduct = new ShopProduct();
            shopProduct.setShop(shop);
            shopProduct.setProduct(product);
            shopProduct.setAvailableForOrdering(false);

            shop.getShopHasProducts().add(shopProduct);
            product.getProductsInShop().add(shopProduct);

            shopRepository.save(shop);
            productRepository.save(product);
        } else {
            shopProduct.setAvailableForOrdering(false);
        }

        shopProductRepository.save(shopProduct);

        return shopProductToShopProductMapperDTO.toDTO(shopProduct);
    }
}
