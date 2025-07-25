package src.saveeatback.web.dtos.responses.produits;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProduitCmdResponse {
    private String id;
    private String libelle;
    private Double prix;
    private Integer qteCommande;

    public static class Builder{
        private String id;
        private String libelle;
        private Double prix;
        private Integer qteCommande;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setLibelle(String libelle) {
            this.libelle = libelle;
            return this;
        }

        public Builder setPrix(Double prix) {
            this.prix = prix;
            return this;
        }

        public Builder setQteCommande(Integer qteCommande) {
            this.qteCommande = qteCommande;
            return this;
        }

        public ProduitCmdResponse build(){return new ProduitCmdResponse(this);}
    }

    public static Builder builder(){return new Builder();}

    public ProduitCmdResponse(Builder builder){
        this.id = builder.id;
        this.prix = builder.prix;
        this.libelle = builder.libelle;
        this.qteCommande = builder.qteCommande;
    }
}
