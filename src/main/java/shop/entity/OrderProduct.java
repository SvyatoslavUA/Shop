package shop.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct {
    @NotNull
    @NotBlank
    private Order orderId;

    @NotNull
    @NotBlank
    private Product productId;

    @NotBlank
    @Min(1)
    private int amount;
}
