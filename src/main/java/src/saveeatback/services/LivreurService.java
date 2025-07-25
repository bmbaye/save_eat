package src.saveeatback.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import src.saveeatback.datas.entities.Livreur;

import java.util.Optional;

public interface LivreurService {
    Page<Livreur> getAllServices(Pageable pageable);
    Optional<Livreur> getOne(String id);
    Optional<Livreur> getOneByTelephone(String telephone);
    Livreur create(Livreur livreur);
}
