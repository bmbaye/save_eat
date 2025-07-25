package src.saveeatback.datas.mocks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import src.saveeatback.datas.entities.Livreur;
import src.saveeatback.datas.repositories.LivreurRepository;

import java.util.ArrayList;
import java.util.List;

//@Component
//@Order(2)
public class LivreurMock implements CommandLineRunner {
    private final LivreurRepository livreurRepository;

    LivreurMock(LivreurRepository livreurRepository){
        this.livreurRepository =livreurRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        List<Livreur> livreurs = new ArrayList<>();
        for (int i =1; i<=2; i++){
            Livreur livreur = new Livreur();
            livreur.setNom("livreurNom "+i);
            livreur.setPrenom("livreurPrenom "+i);
            livreur.setTelephone("77893214"+i);
            livreur.setAdresse("Dakar, rue de la Republique");
            livreur.setImage("default.jpeg");

            livreurs.add(livreur);
        }
        this.livreurRepository.saveAll(livreurs);
        System.out.println("Livreurs enregistrer avec succes");

    }
}
