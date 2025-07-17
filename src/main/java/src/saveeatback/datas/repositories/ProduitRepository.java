package src.saveeatback.datas.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import src.saveeatback.datas.entities.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitRepository extends MongoRepository<Produit, String> {
    @Query("{libelle: ?0}")
    Optional<Produit> findByLibelle(String libelle);

    List<Produit> findAll();

    Optional<Produit> findById(String id);

    boolean existsById(String id);

    long count();

    Page<Produit> findAll(Pageable pageable);

    <S extends Produit> S insert(S produit);

    <S extends Produit> List<S> insert(Iterable<S> produits);
}
