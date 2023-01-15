package shop.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.entity.enumeration.EmployeeRole;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
//    @NotNull
    private Long id;

//    @NotNull
//    @NotBlank
    private String name;

//    @NotNull
//    @NotBlank
    private String surname;

//    @NotNull
//    @NotBlank
    private String password;

//    @NotNull
//    @NotBlank
    private EmployeeRole employeeRole;
}
