package src.saveeatback.services.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import src.saveeatback.datas.entities.BoxSaveEat;
import src.saveeatback.datas.entities.Produit;
import src.saveeatback.datas.entities.ProduitBox;
import src.saveeatback.datas.repositories.ProduitRepository;
import src.saveeatback.services.BoxSaveService;
import src.saveeatback.utils.mappers.ProduitMapper;

import java.time.LocalDate;
import java.util.Collections;

import java.util.List;
import java.util.Random;

@Service
public class BoxSaveServiceImpl implements BoxSaveService {
    private BoxSaveEat box;
    private final ProduitRepository produitRepository;

    BoxSaveServiceImpl(ProduitRepository produitRepository){
        this.produitRepository =produitRepository;
    }

    @PostConstruct
    public void init() {
        generateBoxSaveEat();
    }

    @Override
    @Scheduled(cron = "0 0 0 * * *")
    public void generateBoxSaveEat() {
        List<Produit> allProduits = this.produitRepository.findAll();
        Collections.shuffle(allProduits, new Random(LocalDate.now().hashCode()));
        List<ProduitBox> prodBox = allProduits.stream().map(prod -> ProduitMapper.toProduitBox(prod, 1)).toList();



        this.box = new BoxSaveEat();
        this.box.setProduits(prodBox.stream().limit(6).toList());
        this.box.setPrix(3000.0);
        this.box.setPoids(6.0);
    }



    @Override
    public BoxSaveEat getBoxSaveEat() {
        if (this.box == null) {
            generateBoxSaveEat();
        }
        return this.box;
    }
}
