package src.saveeatback.web.dtos.responses.produits;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleProduitResponse {
    private String id;
    private String libelle;
    private String description;
    private Double prix;
    private String[] image;
    private boolean promo;
    private Integer qteStock;

    public static class Builder{
        private String id;
        private String libelle;
        private String description;
        private Double prix;
        private String[] image;
        private boolean promo;
        private Integer qteStock;

        public Builder setId(String id){
            this.id =id;
            return this;
        }

        public Builder setLibelle(String libelle){
            this.libelle = libelle;
            return this;
        }

        public Builder setDescription(String description){
            this.description = description;
            return this;
        }

        public Builder setPrix(Double prix){
            this.prix = prix;
            return this;
        }

        public Builder setImage(String[] image){
            this.image = image;
            return this;
        }

        public Builder setPromo(boolean promo){
            this.promo =promo;
            return this;
        }

        public Builder setQteStock(Integer qteStock){
            this.qteStock =qteStock;
            return this;
        }

        public SingleProduitResponse build(){return new SingleProduitResponse(this);}

    }

    public static Builder builder(){return new Builder();}

    private SingleProduitResponse(Builder builder){
        this.id =builder.id;
        this.libelle = builder.libelle;
        this.description = builder.description;
        this.prix = builder.prix;
        this.image = builder.image;
        this.qteStock =builder.qteStock;
        this.promo = builder.promo;
    }
}
