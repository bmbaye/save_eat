package src.saveeatback.web.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import src.saveeatback.datas.entities.Client;
import src.saveeatback.utils.validators.ListNotEmpty;

import java.util.List;

@Getter
public class CommandeSubmittedDto {

    @ListNotEmpty
    private List<ProduitCommandeDto> produits;
    @NotNull(message = "L'id du client est obligatoire !")
    private Client client;
    @NotNull
    private LivraisonSubmitted livraison;
    @NotNull
    private PaiementCommandeDto paiement;
}
