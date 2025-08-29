package src.saveeatback.web.dtos.requests;

import jakarta.validation.constraints.NotNull;
import src.saveeatback.utils.validators.ExistingClient;
import src.saveeatback.utils.validators.ListNotEmpty;
import src.saveeatback.utils.validators.ValidTypePaiement;

import java.util.List;


public class CommandeSubmittedDto {
    @ListNotEmpty
    private List<ProduitCommandeDto> produits;
    @NotNull(message = "L'id du client est obligatoire !")
    @ExistingClient
    private String clientId;
    @NotNull
    private LivraisonSubmitted livraison;
    @NotNull
    @ValidTypePaiement
    private String typePaiement;

    public List<ProduitCommandeDto> getProduits() {
        return produits;
    }

    public String getClientId() {
        return clientId;
    }

    public LivraisonSubmitted getLivraison() {
        return livraison;
    }

    public String getTypePaiement() {
        return typePaiement;
    }
}
