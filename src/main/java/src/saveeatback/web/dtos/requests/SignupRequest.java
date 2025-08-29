package src.saveeatback.web.dtos.requests;

import jakarta.validation.constraints.NotNull;
import src.saveeatback.utils.validators.IsValidEmail;
import src.saveeatback.utils.validators.UniqueUsername;

import java.util.List;

public class SignupRequest {
    @UniqueUsername
    private String username;
    @NotNull
    private String password;
    @IsValidEmail
    private String email;
    @NotNull
    private List<String> roles;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getRoles() {
        return roles;
    }
}
