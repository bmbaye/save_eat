package src.saveeatback.datas.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import src.saveeatback.datas.enums.EtatCommande;

import java.util.List;


@Document(collection = "commandes")
public class Commande {
    @Id
    private String id;

    private List<ProduitCommande> produits;

    private EtatCommande etatCommande;

    private Integer nombrePoduits;

    @DBRef
    private Paiement paiement;

    @DBRef
    private Livraison livraison;

    @DBRef
    private Client client;

    public Commande() {
    }

    public Commande(String id, List<ProduitCommande> produits, EtatCommande etatCommande, Integer nombrePoduits, Paiement paiement, Livraison livraison, Client client) {
        this.id = id;
        this.produits = produits;
        this.etatCommande = etatCommande;
        this.nombrePoduits = nombrePoduits;
        this.paiement = paiement;
        this.livraison = livraison;
        this.client = client;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProduits(List<ProduitCommande> produits) {
        this.produits = produits;
    }

    public void setEtatCommande(EtatCommande etatCommande) {
        this.etatCommande = etatCommande;
    }

    public void setNombrePoduits(Integer nombrePoduits) {
        this.nombrePoduits = nombrePoduits;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }

    public void setLivraison(Livraison livraison) {
        this.livraison = livraison;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getId() {
        return id;
    }

    public List<ProduitCommande> getProduits() {
        return produits;
    }

    public EtatCommande getEtatCommande() {
        return etatCommande;
    }

    public Integer getNombrePoduits() {
        return nombrePoduits;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public Livraison getLivraison() {
        return livraison;
    }

    public Client getClient() {
        return client;
    }
}
