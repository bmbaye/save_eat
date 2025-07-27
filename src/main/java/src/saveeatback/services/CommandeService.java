package src.saveeatback.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import src.saveeatback.datas.entities.Client;
import src.saveeatback.datas.entities.Commande;

import java.util.Optional;

public interface CommandeService {
    Optional<Commande> getOne(String id);
    Page<Commande> getAll(Pageable pageable);
    Commande create(Commande commande);
    Optional<Commande> getByClient(Client client);


}
