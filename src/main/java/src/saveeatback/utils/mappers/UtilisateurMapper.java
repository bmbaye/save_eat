package src.saveeatback.utils.mappers;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import src.saveeatback.datas.entities.Utilisateur;
import src.saveeatback.web.dtos.requests.SignupRequest;
import src.saveeatback.web.dtos.responses.utilisateur.UserCreateResponse;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    UtilisateurMapper INSTANCE = Mappers.getMapper(UtilisateurMapper.class);

    @Mapping(target = "roles", expression = "java(new java.util.HashSet<>(signupDto.getRoles()))")
    @Mapping(target = "password", ignore = true)
    Utilisateur signupDtoToUser(SignupRequest signupDto);

    @AfterMapping
    default void encodePassword(SignupRequest dto, @MappingTarget Utilisateur utilisateur, @Context BCryptPasswordEncoder encoder) {
        utilisateur.setPassword(encoder.encode(dto.getPassword()));
    }

    UserCreateResponse toUserCreateResponse(Utilisateur utilisateur);
}
