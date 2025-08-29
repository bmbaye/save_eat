package src.saveeatback.web.dtos.requests;

import jakarta.validation.constraints.NotNull;
import src.saveeatback.utils.validators.UniqueClientTelephone;
import src.saveeatback.utils.validators.UniqueUsername;

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

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getVille() {
        return ville;
    }

    public String getRue() {
        return rue;
    }

    public String getImage() {
        return image;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
