package src.saveeatback.web.dtos.responses.commandes;


import src.saveeatback.datas.enums.EtatCommande;
import src.saveeatback.datas.enums.TypePaiement;



public class CommandeResponse {
    private String id;
//    private List<ProduitCmd> produits;
    private EtatCommande etatCommande;
    private Integer nombrePoduits;
    private TypePaiement typePaiement;
    private Double montant;
    private String livraisonId;
    private String clientId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getLivraisonId() {
        return livraisonId;
    }

    public void setLivraisonId(String livraisonId) {
        this.livraisonId = livraisonId;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public TypePaiement getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(TypePaiement typePaiement) {
        this.typePaiement = typePaiement;
    }

    public Integer getNombrePoduits() {
        return nombrePoduits;
    }

    public void setNombrePoduits(Integer nombrePoduits) {
        this.nombrePoduits = nombrePoduits;
    }

    public EtatCommande getEtatCommande() {
        return etatCommande;
    }

    public void setEtatCommande(EtatCommande etatCommande) {
        this.etatCommande = etatCommande;
    }

    public static class Builder{
        private String id;
//        private List<ProduitCmdResponse> produits;
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

//        public Builder setProduits(List<ProduitCmdResponse> produits) {
//            this.produits = produits;
//            return this;
//        }

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
//        this.produits = builder.produits;
        this.typePaiement = builder.typePaiement;
    }
}
