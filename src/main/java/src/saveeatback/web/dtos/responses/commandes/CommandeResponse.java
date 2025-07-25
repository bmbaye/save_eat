package src.saveeatback.web.dtos.responses.commandes;

import lombok.Getter;

import src.saveeatback.datas.entities.ProduitCommande;
import src.saveeatback.datas.enums.EtatCommande;
import src.saveeatback.datas.enums.TypePaiement;
import src.saveeatback.web.dtos.responses.produits.ProduitCmdResponse;

import java.util.List;

@Getter
public class CommandeResponse {
    private String id;
    private List<ProduitCmdResponse> produits;
    private EtatCommande etatCommande;
    private Integer nombrePoduits;
    private TypePaiement typePaiement;
    private Double montant;
    private String livraisonId;
    private String clientId;

    public static class Builder{
        private String id;
        private List<ProduitCmdResponse> produits;
        private EtatCommande etatCommande;
        private Integer nombrePoduits;
        private TypePaiement typePaiement;
        private Double montant;
        private String livraisonId;
        private String clientId;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setProduits(List<ProduitCmdResponse> produits) {
            this.produits = produits;
            return this;
        }

        public Builder setEtatCommande(EtatCommande etatCommande) {
            this.etatCommande = etatCommande;
            return this;
        }

        public Builder setNombrePoduits(Integer nombrePoduits) {
            this.nombrePoduits = nombrePoduits;
            return this;
        }

        public Builder setTypePaiement(TypePaiement typePaiement) {
            this.typePaiement = typePaiement;
            return this;
        }

        public Builder setMontant(Double montant) {
            this.montant = montant;
            return this;
        }

        public Builder setLivraisonId(String livraisonId) {
            this.livraisonId = livraisonId;
            return this;
        }

        public Builder setClientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public CommandeResponse build(){return new CommandeResponse(this);}

    }

    public static Builder builder(){return new Builder();};

    public CommandeResponse(Builder builder){
        this.id = builder.id;
        this.clientId = builder.clientId;
        this.etatCommande  = builder.etatCommande;
        this.montant = builder.montant;
        this.livraisonId = builder.livraisonId;
        this.nombrePoduits = builder.nombrePoduits;
        this.produits = builder.produits;
        this.typePaiement = builder.typePaiement;
    }
}
