package src.saveeatback.utils.mappers;

import org.springframework.stereotype.Component;
import src.saveeatback.datas.entities.Utilisateur;
import src.saveeatback.datas.enums.RoleUser;
import src.saveeatback.web.dtos.requests.UtilisateurPosted;
import src.saveeatback.web.dtos.responses.utilisateur.UserCreateResponse;

@Component
public class UtilisateurMapper {

    public Utilisateur toUtilisateurEntity(UtilisateurPosted userRequest){
        Utilisateur user = new Utilisateur();

        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setRole(RoleUser.valueOf(userRequest.getRole().toUpperCase()));

        return user;
    }

    public UserCreateResponse toUserCreateResponse(Utilisateur user){
        return UserCreateResponse.builder()
                .setIdUser(user.getId())
                .setUsername(user.getUsername())
                .setMessage("Utilisateur cree avec succes !!")
                .build();
    }

}
