package src.saveeatback.web.dtos.requests;

import jakarta.validation.constraints.NotNull;
import src.saveeatback.utils.validators.UniqueLivreurTelephone;
import src.saveeatback.utils.validators.UniqueUsername;

public class LivreurPosted {
    @NotNull
    private String nom;
    @NotNull
    private String prenom;
    @NotNull
    @UniqueLivreurTelephone
    private String telephone;
    @NotNull
    private String adresse;
    @NotNull
    private String image;
    @NotNull
    @UniqueUsername
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

    public String getAdresse() {
        return adresse;
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
