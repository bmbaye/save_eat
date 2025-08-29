package src.saveeatback.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import src.saveeatback.datas.entities.Utilisateur;
import src.saveeatback.datas.repositories.UtilisateurRepository;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UtilisateurRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur user = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Aucun utilisateur ne porte le nom " + username));

        return UserDetailsImpl.build(user);
    }
}
