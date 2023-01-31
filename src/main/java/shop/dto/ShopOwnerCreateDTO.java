package shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.entity.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopOwnerCreateDTO extends UserDTO{
    private String shopName;

    //    @NotNull
//    @NotBlank
    private String address;

    //    @NotBlank
//    @Min(1)
    private double workingHours;

    //    @NotBlank
//    @Min(1)
    private String workingDays;
}
