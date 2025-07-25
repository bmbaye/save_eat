package src.saveeatback.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import src.saveeatback.datas.entities.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitService {

    Page<Produit> getProduits(Pageable pageable);

    Produit create(Produit produit);

    Optional<Produit> getOneProduit(String id);

    Optional<Produit> getByLibelle(String libelle);

}
