package shop.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.entity.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopDTO {
    @Id
    @NotNull
    private Long id;

    @NotNull
    @NotBlank
    private String shopName;

    @NotNull
    @NotBlank
    private String address;

    @NotBlank
    @Min(1)
    private double workingHours;

    @NotBlank
    @Min(1)
    private String workingDays;

    @NotNull
    @NotBlank
    private User shopOwner;
}
