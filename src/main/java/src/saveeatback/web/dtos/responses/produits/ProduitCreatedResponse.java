package src.saveeatback.web.dtos.responses.produits;

import java.time.LocalDateTime;
import java.util.List;

public class ProduitCreatedResponse {
    private String libelle;
    private String description;
    private Double prix;
    private Integer qteStock;
    private List<String> images;
    private String categorie;
    private LocalDateTime dateExpiration;
    private String etat;
    private Boolean promo;

    public String getLibelle() {
        return libelle;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrix() {
        return prix;
    }

    public Integer getQteStock() {
        return qteStock;
    }

    public List<String> getImages() {
        return images;
    }

    public String getCategorie() {
        return categorie;
    }

    public LocalDateTime getDateExpiration() {
        return dateExpiration;
    }

    public String getEtat() {
        return etat;
    }

    public Boolean getPromo() {
        return promo;
    }

    public ProduitCreatedResponse(String libelle, String description, Double prix, Integer qteStock, List<String> images, String categorie, LocalDateTime dateExpiration, String etat, Boolean promo) {
        this.libelle = libelle;
        this.description = description;
        this.prix = prix;
        this.qteStock = qteStock;
        this.images = images;
        this.categorie = categorie;
        this.dateExpiration = dateExpiration;
        this.etat = etat;
        this.promo = promo;
    }
}
