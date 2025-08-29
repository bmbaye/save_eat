package src.saveeatback.datas.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "livreurs")
public class Livreur {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String telephone;
    private String adresse;
    private String image;
    private UserEntity user;

    public Livreur() {
    }

    public Livreur(String id, String nom, String prenom, String telephone, String adresse, String image, UserEntity user) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.image = image;
        this.user = user;
    }

    public UserEntity getUser() {
        return user;
    }

    public String getImage() {
        return image;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
