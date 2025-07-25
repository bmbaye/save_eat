package src.saveeatback.datas.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import src.saveeatback.datas.entities.Client;
import src.saveeatback.datas.entities.Commande;

import java.util.List;
import java.util.Optional;

public interface CommandeRepository extends MongoRepository<Commande, String> {
    Page<Commande> findAll(Pageable pageable);
    <S extends Commande> S insert(S commande);
    <S extends Commande> List<S> insert(Iterable<S> cmds);

    Optional<Commande> findById(String id);

    Optional<Commande> findByClient(Client client);

}
