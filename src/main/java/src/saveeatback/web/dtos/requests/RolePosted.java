package src.saveeatback.web.dtos.requests;

import jakarta.validation.constraints.NotNull;

public class RolePosted {
    @NotNull
    private String nom;
    public String getNom() {
        return  nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

}
