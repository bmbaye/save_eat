package src.saveeatback.datas.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;
import src.saveeatback.datas.enums.ProduitCategorie;
import src.saveeatback.datas.enums.ProduitEtat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Document(collection = "produits")
public class Produit {
    @Id
    private String id;
    private String libelle;
    private Double prix;
    private Integer qteStock;
    private String description;
    private List<String> images;
    private ProduitCategorie categorie;
    private ProduitEtat etat;
    private LocalDateTime dateExpiration;
    private Boolean promo;

    public Produit(String id, String libelle, Double prix, Integer qteStock, String description, List<String> images, ProduitCategorie categorie, ProduitEtat etat, LocalDateTime dateExpiration, Boolean promo) {
        this.id = id;
        this.libelle = libelle;
        this.prix = prix;
        this.qteStock = qteStock;
        this.description = description;
        this.images = images;
        this.categorie = categorie;
        this.etat = etat;
        this.dateExpiration = dateExpiration;
        this.promo = promo;
    }

    public Produit() {
    }

    public String getId() {
        return id;
    }

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

    public List<String> getImages() {
        return images;
    }

    public ProduitCategorie getCategorie() {
        return categorie;
    }

    public ProduitEtat getEtat() {
        return etat;
    }

    public LocalDateTime getDateExpiration() {
        return dateExpiration;
    }

    public Boolean getPromo() {
        return promo;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void setCategorie(ProduitCategorie categorie) {
        this.categorie = categorie;
    }

    public void setEtat(ProduitEtat etat) {
        this.etat = etat;
    }

    public void setDateExpiration(LocalDateTime dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public void setPromo(Boolean promo) {
        this.promo = promo;
    }
}
