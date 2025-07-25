package src.saveeatback.web.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import src.saveeatback.datas.entities.Livreur;
import src.saveeatback.datas.enums.HoraireLivraison;
import src.saveeatback.datas.enums.TypeLivraison;

import java.util.Date;

@Getter
public class LivraisonSubmitted {
    private TypeLivraison type;
    @NotNull(message = "La date de livraison est obligatoire !!")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateLivraison;
    @NotNull(message = "L'horaire de livraison est obligatoire")
    private HoraireLivraison horaire;
    @NotNull(message = "Le livreur est obligatoire")
    private Livreur livreur;
    @NotNull
    private String ville;
    @NotNull
    private String rue;
}
