package shop.mapper;

import org.springframework.stereotype.Component;
import shop.dto.ProductDTO;
import shop.entity.Product;

@Component
public class ProductToProductMapperDTO {
    public Product toEntity(final ProductDTO productDTO){
        final Product product = new Product();

        product.setName(productDTO.getName());
        product.setId(productDTO.getId());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());

        return product;
    }

    public ProductDTO toDTO(final Product product){
        final ProductDTO productDTO = new ProductDTO();

        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setId(product.getId());
        productDTO.setPrice(product.getPrice());

        return productDTO;
    }
}
