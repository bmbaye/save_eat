package src.saveeatback.datas.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import src.saveeatback.datas.entities.Livreur;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface LivreurRepository extends MongoRepository<Livreur, String> {
    Page<Livreur> findAll(Pageable pageable);
    Optional<Livreur> findById(String id);
    Optional<Livreur> findByTelephone(String telephone);
    <S extends Livreur> S insert(S livreur);
    <S extends Livreur>List<S> insert(Iterable<S> livreurs);
    long count();
}
