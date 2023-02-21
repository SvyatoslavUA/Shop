package shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopOwnerCreateDTO extends UserDTO{
    private String name;

    //    @NotNull
//    @NotBlank
    private String address;

    //    @NotBlank
//    @Min(1)
    private String workingHoursStart;
    private String workingHoursEnd;

    //    @NotBlank
//    @Min(1)
    private List<DayOfWeek> workingDays;
}
