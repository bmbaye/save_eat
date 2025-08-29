package src.saveeatback.datas.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import src.saveeatback.datas.enums.EtatPaiement;
import src.saveeatback.datas.enums.TypePaiement;

import java.util.Date;

@Document(collection = "paiements")
public class Paiement {
    @Id
    private String id;
    private TypePaiement type;
    private Double montant;
    private EtatPaiement etat = EtatPaiement.A_EFFECTUER;
    private Date dateEffectuee;

    public void setId(String id) {
        this.id = id;
    }

    public void setType(TypePaiement type) {
        this.type = type;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public void setEtat(EtatPaiement etat) {
        this.etat = etat;
    }

    public void setDateEffectuee(Date dateEffectuee) {
        this.dateEffectuee = dateEffectuee;
    }

    public String getId() {
        return id;
    }

    public TypePaiement getType() {
        return type;
    }

    public Double getMontant() {
        return montant;
    }

    public EtatPaiement getEtat() {
        return etat;
    }

    public Date getDateEffectuee() {
        return dateEffectuee;
    }

    public Paiement() {
    }

    public Paiement(String id, TypePaiement type, Double montant, EtatPaiement etat, Date dateEffectuee) {
        this.id = id;
        this.type = type;
        this.montant = montant;
        this.etat = etat;
        this.dateEffectuee = dateEffectuee;
    }
}
