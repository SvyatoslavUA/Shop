package shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
//    @NotNull
    private Long id;

//    @NotNull
//    @NotBlank
    private String productName;

//    @NotNull
//    @NotBlank
    private String description;

//    @NotBlank
//    @Min(1)
    private double price;


}
