package src.saveeatback.web.controllers.impl;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import src.saveeatback.datas.entities.Produit;
import src.saveeatback.services.ProduitService;
import src.saveeatback.services.impl.ProduitServiceImpl;
import src.saveeatback.web.controllers.ProduitController;

import java.util.List;

@RestController
public class ProduitControllerImpl implements ProduitController {

    private final ProduitService produitService;

    public ProduitControllerImpl(ProduitService produitService){
        this.produitService =produitService;
    }

    @Override
    public ResponseEntity<List<Produit>> getProduits(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        var produits = this.produitService.getProduits(pageable);

        return new ResponseEntity<>(produits.toList(),HttpStatus.OK);
    }
}
