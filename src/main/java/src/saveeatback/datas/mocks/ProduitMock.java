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
            switch (i){
                case 1:
                    prod.setLibelle("Pasteque");
                    prod.setCategorie(ProduitCategorie.FRUIT);
                    prod.setDescription("Ceci est de la pasteque");
                    break;
                case 2:
                    prod.setLibelle("Pomme de terre");
                    prod.setCategorie(ProduitCategorie.LEGUME);
                    prod.setDescription("Ceci est de la pomme de terre");
                    break;
                case 3:
                    prod.setLibelle("Bananne ");
                    prod.setCategorie(ProduitCategorie.FRUIT);
                    prod.setDescription("Ceci est du bananne");
                    break;
                case 4:
                    prod.setLibelle("Aubergine");
                    prod.setCategorie(ProduitCategorie.LEGUME);
                    prod.setDescription("Ceci est de l'aubergine");
                    break;
                case 5:
                    prod.setLibelle("Tomate");
                    prod.setCategorie(ProduitCategorie.FRUIT);
                    prod.setDescription("Ceci est de la tomate");
                    break;
            }
            prod.setPrix(1000.0 * i);
            String[] images ={"default_image1.png", "default_image2.png"};
            prod.setImages(images);
            prod.setPromo(false);
            prod.setDateExpiration(LocalDateTime.now());
            prod.setQteStock(100);
            produits.add(prod);
        }
        produitRepository.saveAll(produits);
        System.out.println("Produits insérés !");
    }
}
