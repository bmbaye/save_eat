package src.saveeatback.datas.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import src.saveeatback.datas.entities.Utilisateur;

import java.util.Optional;

public interface UtilisateurRepository extends MongoRepository<Utilisateur, String> {
    Optional<Utilisateur> findByUsername(String username);
    Optional<Utilisateur> findByUsernameAndPassword(String username, String password);

}
