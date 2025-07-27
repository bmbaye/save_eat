package src.saveeatback.web.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import src.saveeatback.utils.validators.UniqueClientTelephone;
import src.saveeatback.utils.validators.UniqueUsername;

@Getter
public class ClientPosted {
    @NotNull
    private String nom;
    @NotNull
    private String prenom;
    @UniqueClientTelephone
    @NotNull
    private String telephone;
    @NotNull
    private String ville;
    @NotNull
    private String rue;
    @NotNull
    private String image;
    @UniqueUsername
    @NotNull
    private String username;
    @NotNull
    private String password;
}
