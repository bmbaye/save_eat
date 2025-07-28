package src.saveeatback.utils.mappers;

import org.springframework.stereotype.Component;
import src.saveeatback.datas.entities.Livraison;
import src.saveeatback.datas.entities.Livreur;
import src.saveeatback.datas.enums.EtatLivraison;
import src.saveeatback.datas.enums.HoraireLivraison;
import src.saveeatback.datas.enums.TypeLivraison;
import src.saveeatback.datas.repositories.LivreurRepository;
import src.saveeatback.web.dtos.requests.LivraisonSubmitted;

import java.util.Optional;

@Component
public class LivraisonMapper {

    private final LivreurRepository livreurRepository;

    LivraisonMapper(LivreurRepository livreurRepository){
        this.livreurRepository = livreurRepository;
    }

    public Livraison toLivraison(LivraisonSubmitted livraisonSubmitted){
        Livraison livraison = new Livraison();

        livraison.setDateLivraison(livraisonSubmitted.getDateLivraison());
        livraison.setEtat(EtatLivraison.EN_OPERATION);
        livraison.setLivreur(null);
        livraison.setRue(livraisonSubmitted.getRue());
        livraison.setVille(livraisonSubmitted.getVille());
        livraison.setHoraire(HoraireLivraison.valueOf(livraisonSubmitted.getHoraire().toUpperCase()));
        livraison.setType(TypeLivraison.valueOf(livraisonSubmitted.getType().toUpperCase()));

        return livraison;
    }
}
