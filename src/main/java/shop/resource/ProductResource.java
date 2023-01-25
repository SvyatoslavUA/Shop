package shop.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.dto.ProductDTO;
import shop.service.ProductService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/product")
public class ProductResource {
    @Autowired
    private ProductService productService;

    @GetMapping("/shop-owner")
    public List<ProductDTO> getAllProductsForShopOwner(@PathVariable Long userId){
        return productService.getAllProductsForShopOwner(userId);
    }

    @GetMapping("/user")
    public ProductDTO getProductById(@PathVariable Long productId){
        return productService.getProductById(productId);
    }

    @PutMapping("/adding")
    public ProductDTO addProducts(@RequestBody ProductDTO productDTO){
        return productService.addProducts(productDTO);
    }

    @GetMapping("/customer")
    public List<ProductDTO> getAllProductsForCustomer(){
        return productService.getAllProductsForCustomer();
    }
}
