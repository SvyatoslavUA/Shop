package shop.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.dto.ProductDTO;
import shop.dto.ShopProductDTO;
import shop.service.ProductService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/product")
public class ProductResource {
    @Autowired
    private ProductService productService;

    @GetMapping("/shop-owner/{userId}")
    public List<ProductDTO> getAllProductsForShopOwner(@PathVariable Long userId){
        return productService.getAllProductsForShopOwner(userId);
    }

    @GetMapping("/user/{productId}")
    public List<ShopProductDTO> getProductById(@PathVariable Long productId){
        return productService.getProductById(productId);
    }

    @PutMapping("/adding")
    public ProductDTO addProducts(@RequestBody ProductDTO productDTO){
        return productService.addProducts(productDTO);
    }

    @GetMapping("/available-products")
    public List<ProductDTO> getAllProductsForCustomer(){
        return productService.getAllProductsForCustomer();
    }

    @GetMapping("/best-product/{productIds}")
    ProductDTO getBestProductFromEntered(@PathVariable List<Long> productIds){
        return productService.getBestProductFromEntered(productIds);
    }
}
