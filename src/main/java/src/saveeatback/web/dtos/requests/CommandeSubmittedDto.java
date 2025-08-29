package src.saveeatback.web.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import src.saveeatback.utils.validators.ExistingClient;
import src.saveeatback.utils.validators.ListNotEmpty;
import src.saveeatback.utils.validators.ValidTypePaiement;

import java.util.List;

@Getter
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
}
