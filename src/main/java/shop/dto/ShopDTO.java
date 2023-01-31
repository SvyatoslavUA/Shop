package shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopDTO {
//    @NotNull
    private Long id;

//    @NotNull
//    @NotBlank
    private String name;

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
