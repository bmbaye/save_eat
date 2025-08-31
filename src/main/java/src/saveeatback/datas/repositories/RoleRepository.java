package src.saveeatback.datas.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import src.saveeatback.datas.entities.Role;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByNomRole(String nomRole);
}
