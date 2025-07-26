package src.saveeatback.web.dtos.responses.box;

import lombok.Getter;
import src.saveeatback.datas.entities.ProduitBox;

import java.util.List;

@Getter
public class BoxSaveEatResponse {
    private List<ProduitBox> produits;
    private Double poids;
    private Double prix;

    public static class Builder{
        private List<ProduitBox> produits;
        private Double poids;
        private Double prix;

        public Builder setProduits(List<ProduitBox> produits) {
            this.produits = produits;
            return this;
        }

        public Builder setPoids(Double poids) {
            this.poids = poids;
            return this;
        }

        public Builder setPrix(Double prix) {
            this.prix = prix;
            return this;
        }

        public BoxSaveEatResponse build(){return new BoxSaveEatResponse(this);}

    }

    public static Builder builder(){return new Builder();}

    public BoxSaveEatResponse(Builder builder){
        this.poids = builder.poids;
        this.produits = builder.produits;
        this.prix = builder.prix;
    }
}
