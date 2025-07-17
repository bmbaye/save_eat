package src.saveeatback.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import src.saveeatback.datas.entities.Produit;

import java.util.List;

@RequestMapping(value = "api/v1/produits")
public interface ProduitController {
    @GetMapping("")
    ResponseEntity<List<Produit>> getProduits(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size);
}
