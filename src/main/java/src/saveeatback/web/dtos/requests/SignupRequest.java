package src.saveeatback.web.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import src.saveeatback.utils.validators.IsValidEmail;
import src.saveeatback.utils.validators.UniqueUsername;

import java.util.List;

@Getter
@Setter
public class SignupRequest {
    @UniqueUsername
    private String username;
    @NotNull
    private String password;
    @IsValidEmail
    private String email;
    @NotNull
    private List<String> roles;
}
