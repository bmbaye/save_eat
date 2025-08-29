package src.saveeatback.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import src.saveeatback.datas.entities.Utilisateur;
import src.saveeatback.web.dtos.requests.SignupRequest;
import src.saveeatback.web.dtos.responses.utilisateur.UserCreateResponse;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    UtilisateurMapper INSTANCE = Mappers.getMapper(UtilisateurMapper.class);

    Utilisateur signupDtoToUser(SignupRequest signupDto);

    UserCreateResponse toUserCreateResponse(Utilisateur utilisateur);
}
