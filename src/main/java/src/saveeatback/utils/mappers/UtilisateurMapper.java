package src.saveeatback.utils.mappers;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.password.PasswordEncoder;
import src.saveeatback.datas.entities.Role;
import src.saveeatback.datas.entities.Utilisateur;
import src.saveeatback.web.dtos.requests.SignupRequest;
import src.saveeatback.web.dtos.responses.utilisateur.UserCreateResponse;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    UtilisateurMapper INSTANCE = Mappers.getMapper(UtilisateurMapper.class);

    @Mapping(target = "password", expression = "java(passwordEncoder.encode(signupDto.getPassword()))")
    @Mapping(target = "roles", source = "roles")
    Utilisateur signupDtoToUser(SignupRequest signupDto, @Context PasswordEncoder passwordEncoder);

    UserCreateResponse toUserCreateResponse(Utilisateur utilisateur);

    default List<Role> mapRoles(List<String> roles) {
        if (roles == null) {
            return new ArrayList<>();
        }
        List<Role> rolesList = new ArrayList<>();
        for (String role : roles) {
            Role roleObject = new Role();
            roleObject.setNomRole(role);
            rolesList.add(roleObject);
        }
        return rolesList;
    }

    default List<String> mapRoleString(List<Role> roles){
        if (roles == null) {
            return new ArrayList<>();
        }
        List<String> rolesString = new ArrayList<>();
        for (Role role : roles) {
            rolesString.add(role.getNomRole());
        }
        return rolesString;
    }
}
