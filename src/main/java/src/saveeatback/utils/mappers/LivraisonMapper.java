package src.saveeatback.utils.mappers;

import src.saveeatback.datas.entities.Livraison;
import src.saveeatback.datas.enums.EtatLivraison;
import src.saveeatback.web.dtos.requests.LivraisonSubmitted;

public class LivraisonMapper {

    public static Livraison toLivraison(LivraisonSubmitted livraisonSubmitted){
        Livraison livraison = new Livraison();

        livraison.setDateLivraison(livraisonSubmitted.getDateLivraison());
        livraison.setEtat(EtatLivraison.EN_OPERATION);
        livraison.setLivreur(livraisonSubmitted.getLivreur());
        livraison.setRue(livraisonSubmitted.getRue());
        livraison.setVille(livraisonSubmitted.getVille());
        livraison.setHoraire(livraisonSubmitted.getHoraire());
        livraison.setType(livraisonSubmitted.getType());

        return livraison;
    }
}
