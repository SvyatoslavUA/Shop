package shop.service;

import shop.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProductsForShopOwner(Long userId);
    ProductDTO getProductById(Long productId);
    ProductDTO addProducts(ProductDTO productDTO);
    List<ProductDTO> getAllProductsForCustomer();
}
