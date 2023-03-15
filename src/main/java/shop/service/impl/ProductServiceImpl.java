package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dto.ProductDTO;
import shop.dto.ShopProductDTO;
import shop.entity.Product;
import shop.entity.User;
import shop.entity.enumeration.UserRole;
import shop.exeption.ServiceException;
import shop.mapper.ProductToProductMapperDTO;
import shop.mapper.ShopProductToShopProductMapperDTO;
import shop.repositiry.ProductRepository;
import shop.repositiry.ShopProductRepository;
import shop.repositiry.UserRepository;
import shop.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductToProductMapperDTO productToProductMapperDTO;

    @Autowired
    private ShopProductRepository shopProductRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShopProductToShopProductMapperDTO shopProductToShopProductMapperDTO;
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProductsForShopOwner(Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new ServiceException(400, "!!!"));
        if (user.getRole() != UserRole.SHOP_OWNER) {
            throw new ServiceException(400, "User are not shop owner!!!");
        }

        return productRepository.findAll().stream()
                .map(productToProductMapperDTO::toDTO).collect(Collectors.toList());
    }
    public List<ShopProductDTO> getProductById(Long productId){
        return shopProductRepository.getAvailableProductsById(productId).stream()
                .map(shopProductToShopProductMapperDTO::toDTO).toList();
    }
    public ProductDTO addProducts(ProductDTO productDTO){
        final Product product = productToProductMapperDTO.toEntity(productDTO);

        productRepository.save(product);

        return productToProductMapperDTO.toDTO(product);
    }
    public List<ShopProductDTO> getAllProductsForCustomer(){
        return shopProductRepository.getAvailableProducts().stream()
                .map(shopProductToShopProductMapperDTO::toDTO).toList();
    }

}
