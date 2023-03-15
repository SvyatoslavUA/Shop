package shop.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import shop.entity.enumeration.UserRole;

@Data
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String email;

    private UserRole role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}
