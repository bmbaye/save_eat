package src.saveeatback.web.dtos.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;
import src.saveeatback.datas.enums.ProduitEtat;
import src.saveeatback.utils.validators.*;

import java.time.LocalDateTime;
import java.util.List;

public class ProduitPosted {
    @NotNull
    @NotEmpty
    private String libelle;
    @ValidPrix
    private Double prix;
    @ValidQuantity
    private Integer qteStock;
    private String description;
    @ListNotEmpty
    private List<MultipartFile> images;
    @ValidCategorieProduit
    private String categorie;
    @ValidEtatProduit
    private String etat;
    @NotNull
    private LocalDateTime dateExpiration;
    private Boolean promo;

    public String getLibelle() {
        return libelle;
    }

    public Double getPrix() {
        return prix;
    }

    public Integer getQteStock() {
        return qteStock;
    }

    public String getDescription() {
        return description;
    }

    public List<MultipartFile> getImages() {
        return images;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getEtat() {
        return etat;
    }

    public LocalDateTime getDateExpiration() {
        return dateExpiration;
    }

    public Boolean getPromo() {
        return promo;
    }
}
