package src.saveeatback.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import src.saveeatback.datas.entities.Livraison;

import java.util.Date;
import java.util.Optional;

public interface LivraisonService {
    Page<Livraison> getAllLivraisons(Pageable pageable);
    Optional<Livraison> getOne(String id);
    Page<Livraison> getByDateLivraison(Date date, Pageable pageable);
    Livraison create(Livraison livraison);
}
