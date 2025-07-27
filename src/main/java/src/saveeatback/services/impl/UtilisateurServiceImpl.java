package src.saveeatback.services.impl;

import org.springframework.stereotype.Service;
import src.saveeatback.datas.entities.Utilisateur;
import src.saveeatback.datas.repositories.UtilisateurRepository;
import src.saveeatback.services.UtilisateurService;

import java.util.Optional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository = utilisateurRepository;
    }
    @Override
    public Utilisateur create(Utilisateur utilisateur) {
        return this.utilisateurRepository.save(utilisateur);
    }

    @Override
    public Optional<Utilisateur> getByUsernameAndPassword(String username, String password) {
        return this.utilisateurRepository.findByUsernameAndPassword(username, password);
    }
}
