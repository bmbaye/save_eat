package src.saveeatback.web.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import src.saveeatback.datas.entities.UserEntity;
import src.saveeatback.utils.validators.UniqueLivreurTelephone;
import src.saveeatback.utils.validators.UniqueUsername;

@Getter
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
}
