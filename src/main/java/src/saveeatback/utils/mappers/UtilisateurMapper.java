package src.saveeatback.utils.mappers;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.password.PasswordEncoder;
import src.saveeatback.datas.entities.Utilisateur;
import src.saveeatback.web.dtos.requests.SignupRequest;
import src.saveeatback.web.dtos.responses.utilisateur.UserCreateResponse;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    UtilisateurMapper INSTANCE = Mappers.getMapper(UtilisateurMapper.class);

    @Mapping(target = "password", expression = "java(passwordEncoder.encode(signupDto.getPassword()))")
    Utilisateur signupDtoToUser(SignupRequest signupDto, @Context PasswordEncoder passwordEncoder);

    UserCreateResponse toUserCreateResponse(Utilisateur utilisateur);
}
