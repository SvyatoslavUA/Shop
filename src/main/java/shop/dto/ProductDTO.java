package shop.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @Id
    @NotNull
    private Long id;

    @NotNull
    @NotBlank
    private String productName;

    @NotNull
    @NotBlank
    private String description;

    @NotBlank
    @Min(1)
    private double price;
}
