package src.saveeatback.datas.entities;


import java.util.List;


public class BoxSaveEat {
    private List<ProduitBox> produits;
    private Double prix;
    private Double poids;

    public void setProduits(List<ProduitBox> produits) {
        this.produits = produits;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    public List<ProduitBox> getProduits() {
        return produits;
    }

    public Double getPrix() {
        return prix;
    }

    public Double getPoids() {
        return poids;
    }
}
