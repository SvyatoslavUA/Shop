package shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.entity.enumeration.Material;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
//    @NotNull
    private Long id;

//    @NotNull
//    @NotBlank
    private String name;

//    @NotNull
//    @NotBlank
    private String description;

//    @NotBlank
//    @Min(1)
    private double price;

    private ProducerDTO producer;

    private double guarantee;

    private Material material;
}
