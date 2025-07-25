package src.saveeatback.datas.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import src.saveeatback.datas.entities.Livraison;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface LivraisonRepository extends MongoRepository<Livraison, String> {
    Page<Livraison> findAll(Pageable pageable);
    Optional<Livraison> findById(String id);
    Page<Livraison> findAllByDateLivraison(Date date, Pageable pageable);
    <S extends Livraison> S insert(S livraison);
    <S extends Livraison> List<S> insert(Iterable<S> livraisons);
    long count();
}
