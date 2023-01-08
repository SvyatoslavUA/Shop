package shop.service;

import shop.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProductsForShopOwner();
    ProductDTO getProductById(Long id);
    ProductDTO addProducts(ProductDTO productDTO);
    List<ProductDTO> getAllProductsForCustomer();
}
