package src.saveeatback.services;

import src.saveeatback.datas.entities.Utilisateur;

import java.util.Optional;

public interface UtilisateurService {
    Utilisateur create(Utilisateur utilisateur);
    Optional<Utilisateur> getByUsernameAndPassword(String username, String password);
}
