package src.saveeatback.datas.entities;
import src.saveeatback.datas.enums.ProduitEtat;


public class ProduitCommande {
    private String id;
    private String libelle;
    private Double prix;
    private Integer qteCommande;

    public ProduitCommande() {
    }

    public ProduitCommande(String id, String libelle, Double prix, Integer qteCommande) {
        this.id = id;
        this.libelle = libelle;
        this.prix = prix;
        this.qteCommande = qteCommande;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getQteCommande() {
        return qteCommande;
    }

    public void setQteCommande(Integer qteCommande) {
        this.qteCommande = qteCommande;
    }
}
