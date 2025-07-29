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
        List<Produit> fruits = new ArrayList<>();
        List<Produit> legumes = new ArrayList<>();

        for (int i =1; i<=5; i++){
            Produit fruit = new Produit();
            Produit legume = new Produit();
            fruit.setEtat(ProduitEtat.DISPONIBLE);
            legume.setEtat(ProduitEtat.DISPONIBLE);
            fruit.setCategorie(ProduitCategorie.FRUIT);
            legume.setCategorie(ProduitCategorie.LEGUME);
            switch (i){
                case 1:
                    fruit.setLibelle("Pomme");
                    fruit.setPrix(1000.0);
                    fruit.setDescription("Ceci est de la Pomme");

                    legume.setLibelle("Carotte");
                    legume.setDescription("Ceci est de la Carotte");
                    legume.setPrix(1000.0);
                    break;
                case 2:
                    fruit.setLibelle("Poire");
                    fruit.setDescription("Ceci est de la Poire");
                    fruit.setPrix(1000.0);

                    legume.setLibelle("Pomme de terre");
                    legume.setPrix(1000.0);
                    legume.setDescription("Ceci est de la Pomme de terre");
                    break;
                case 3:
                    fruit.setLibelle("Orange");
                    fruit.setDescription("Ceci est de la Orange");
                    fruit.setPrix(750.0);

                    legume.setLibelle("Concombre");
                    legume.setDescription("Ceci est du Concombre");
                    fruit.setPrix(1200.0);
                    break;
                case 4:
                    fruit.setLibelle("Mangue");
                    fruit.setDescription("Ceci est de la Mangue");
                    fruit.setPrix(600.0);

                    legume.setLibelle("Oignon");
                    legume.setDescription("Ceci est de l'Oignon");
                    legume.setPrix(600.0);
                    break;
                case 5:
                    fruit.setLibelle("Ananas");
                    fruit.setDescription("Ceci est de l'Ananas");
                    fruit.setPrix(800.0);

                    legume.setLibelle("Poivron");
                    legume.setDescription("Ceci est du Poivron");
                    legume.setPrix(500.0);
                    break;
            }
            String[] images ={"default_image1.png", "default_image2.png"};
            fruit.setImages(images);
            legume.setImages(images);
            fruit.setPromo(false);
            legume.setPromo(false);
            fruit.setDateExpiration(LocalDateTime.now());
            legume.setDateExpiration(LocalDateTime.now());
            fruit.setQteStock(150);
            legume.setQteStock(150);
            fruits.add(fruit);
            legumes.add(legume);
        }
        produitRepository.saveAll(legumes);
        produitRepository.saveAll(fruits);
        System.out.println("Produits insérés !");
    }
}
