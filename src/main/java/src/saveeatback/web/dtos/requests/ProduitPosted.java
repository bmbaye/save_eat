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

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public void setQteStock(Integer qteStock) {
        this.qteStock = qteStock;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie.toUpperCase();
    }

    public void setEtat(String etat) {
        this.etat = etat.toUpperCase();
    }

    public void setDateExpiration(LocalDateTime dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public void setPromo(Boolean promo) {
        this.promo = promo;
    }
}
