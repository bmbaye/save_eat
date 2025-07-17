package src.saveeatback.datas.mocks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import src.saveeatback.datas.entities.Produit;
import src.saveeatback.datas.enums.ProduitCategorie;
import src.saveeatback.datas.enums.ProduitEtat;
import src.saveeatback.datas.repositories.ProduitRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@Component
public class ProduitMock implements CommandLineRunner {
    private final ProduitRepository produitRepository;

    public ProduitMock(ProduitRepository produitRepository){
        this.produitRepository = produitRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Produit> produits = new ArrayList<>();

        for (int i =1; i<=5; i++){
            Produit prod = new Produit();
            prod.setEtat(ProduitEtat.DISPONIBLE);
            prod.setLibelle("Produit "+ i);
            prod.setCategorie(ProduitCategorie.FRUIT);
            prod.setPrix(1000.0 * i);
            prod.setDescription("Decription produit " +i);
            prod.setImages(null);
            prod.setPromo(false);
            prod.setDateExpiration(LocalDateTime.now());
            prod.setQteStock(100);
            if(i%2 ==0){
                prod.setCategorie(ProduitCategorie.LEGUME);
            }
            produits.add(prod);
        }
        produitRepository.saveAll(produits);
        System.out.println("Produits insérés !");
    }
}
