package shop.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.entity.OrderProduct;
import shop.entity.Shop;
import shop.entity.User;
import shop.entity.enumeration.Status;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    @Id
    @NotNull
    private Long id;

    @NotNull
    @NotBlank
    private User customerId;

    @NotBlank
    @NotNull
    private List<OrderProductDTO> orderedProductWithAmount;

    @NotNull
    @NotBlank
    private Shop shopId;

    @NotNull
    @NotBlank
    private User courierId;

    @NotNull
    @NotBlank
    private String shippingAddress;

    @NotBlank
    @Min(1)
    private double totalAmount;

    @NotNull
    @NotBlank
    private Status status;
}
