package src.saveeatback.datas.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "clients")
public class Client {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String telephone;
    private String ville;
    private String rue;
    private String image;
    private UserEntity user;

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getVille() {
        return ville;
    }

    public String getRue() {
        return rue;
    }

    public String getImage() {
        return image;
    }

    public UserEntity getUser() {
        return user;
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

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Client() {
    }

    public Client(String id, String nom, String prenom, String telephone, String ville, String rue, String image, UserEntity user) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.ville = ville;
        this.rue = rue;
        this.image = image;
        this.user = user;
    }
}
