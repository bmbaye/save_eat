package src.saveeatback.web.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import src.saveeatback.datas.enums.RoleUser;
import src.saveeatback.utils.validators.UniqueUsername;

@Getter
@Setter
public class UtilisateurPosted {
    @UniqueUsername
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String role;
}
