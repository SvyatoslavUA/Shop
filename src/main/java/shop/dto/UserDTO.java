package shop.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.entity.enumeration.UserRole;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
//    @NotNull
    private Long id;

    private String email;

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
    private UserRole role;
}
