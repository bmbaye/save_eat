package src.saveeatback.utils.mappers;

import src.saveeatback.datas.entities.Paiement;
import src.saveeatback.datas.enums.EtatPaiement;
import src.saveeatback.web.dtos.requests.PaiementCommandeDto;

public class PaiementMapper {

    public static Paiement toPaiement(PaiementCommandeDto paiementDto){
        Paiement paiement = new Paiement();
        paiement.setType(paiementDto.getType());
        paiement.setMontant(paiementDto.getMontant());
        paiement.setEtat(EtatPaiement.A_EFFECTUER);
        paiement.setDateEffectuee(null);

        return paiement;
    }
}
