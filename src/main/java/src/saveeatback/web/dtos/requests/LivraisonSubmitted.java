package src.saveeatback.web.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import src.saveeatback.utils.validators.ValidTypeLivraison;

import java.util.Date;

public class LivraisonSubmitted {
    @ValidTypeLivraison
    private String type;
    @NotNull(message = "La date de livraison est obligatoire !!")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateLivraison;
    @NotNull(message = "L'horaire de livraison est obligatoire")
    private String horaire;
    @NotNull
    private String ville;
    @NotNull
    private String rue;

    public String getType() {
        return type;
    }

    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }

    public String getHoraire() {
        return horaire;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }
}