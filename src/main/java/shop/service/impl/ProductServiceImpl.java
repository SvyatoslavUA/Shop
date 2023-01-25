package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dto.ProductDTO;
import shop.mapper.ProductToProductMapperDTO;
import shop.repositiry.ProductRepository;
import shop.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductToProductMapperDTO productToProductMapperDTO;

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProductsForShopOwner(Long userId){
        return null;
    }
    public ProductDTO getProductById(Long productId){
        return null;
    }
    public ProductDTO addProducts(ProductDTO productDTO){
        return null;
    }
    public List<ProductDTO> getAllProductsForCustomer(){
        return null;
    }

}
