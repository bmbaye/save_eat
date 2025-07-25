package src.saveeatback.datas.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import src.saveeatback.datas.entities.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends MongoRepository<Client, String> {

    Optional<Client> findById(String id);

    <S extends Client> S insert(S Client);

    <S extends Client> List<S> insert(Iterable<S> client);

    Page<Client> findAll(Pageable pageable);

    boolean existsById(String id);

    Optional<Client> findByTelephone(String telephone);
    long count();
}
