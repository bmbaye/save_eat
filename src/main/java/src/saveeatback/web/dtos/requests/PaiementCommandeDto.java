package src.saveeatback.web.dtos.requests;

import lombok.Getter;
import src.saveeatback.datas.enums.TypePaiement;

@Getter
public class PaiementCommandeDto {
    private TypePaiement type;
    private Double montant;
}
