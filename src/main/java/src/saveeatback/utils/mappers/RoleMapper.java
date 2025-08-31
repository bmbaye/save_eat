package src.saveeatback.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import src.saveeatback.datas.entities.Role;
import src.saveeatback.web.dtos.requests.RolePosted;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    @Mapping(target = "nomRole", source = "nom")
    Role toRole(RolePosted rolePosted);

    RolePosted toRolePosted(Role role);
}
