package src.saveeatback.datas.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import src.saveeatback.datas.entities.Paiement;

public interface PaiementRepository extends MongoRepository<Paiement, String> {
}
