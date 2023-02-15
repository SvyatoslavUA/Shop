package shop.service;

import shop.dto.ProductDTO;
import shop.dto.ShopProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProductsForShopOwner(Long userId);
    List<ShopProductDTO> getProductById(Long productId);
    ProductDTO addProducts(ProductDTO productDTO);
    List<ShopProductDTO> getAllProductsForCustomer();
}
