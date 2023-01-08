package shop.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.entity.Order;
import shop.entity.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductDTO {
    @Id
    @NotNull
    private Order orderId;

    @Id
    @NotNull
    private Product productId;

    @NotBlank
    @Min(1)
    private int amount;
}
