package src.saveeatback.datas.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import src.saveeatback.datas.enums.EtatLivraison;
import src.saveeatback.datas.enums.HoraireLivraison;
import src.saveeatback.datas.enums.TypeLivraison;

import java.util.Date;


@Document(collection = "livraisons")
public class Livraison {
    @Id
    private String id;

    @DBRef
    private Livreur livreur;

    private TypeLivraison type;

    private Date dateLivraison;

    private HoraireLivraison horaire;

    private EtatLivraison etat;

    private String ville;

    private String rue;

    public String getId() {
        return id;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public TypeLivraison getType() {
        return type;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public HoraireLivraison getHoraire() {
        return horaire;
    }

    public EtatLivraison getEtat() {
        return etat;
    }

    public String getVille() {
        return ville;
    }

    public String getRue() {
        return rue;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }

    public void setType(TypeLivraison type) {
        this.type = type;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public void setHoraire(HoraireLivraison horaire) {
        this.horaire = horaire;
    }

    public void setEtat(EtatLivraison etat) {
        this.etat = etat;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public Livraison() {
    }

    public Livraison(String id, Livreur livreur, TypeLivraison type, Date dateLivraison, HoraireLivraison horaire, EtatLivraison etat, String ville, String rue) {
        this.id = id;
        this.livreur = livreur;
        this.type = type;
        this.dateLivraison = dateLivraison;
        this.horaire = horaire;
        this.etat = etat;
        this.ville = ville;
        this.rue = rue;
    }
}
