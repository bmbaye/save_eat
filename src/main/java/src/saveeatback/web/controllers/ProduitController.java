package src.saveeatback.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import src.saveeatback.datas.entities.Produit;
import src.saveeatback.web.dtos.responses.RestResponse;
import src.saveeatback.web.dtos.responses.produits.ProduitCatalogueResponse;

import java.util.List;
import java.util.Map;

@RequestMapping(value = "api/v1/produits")
public interface ProduitController {
    @GetMapping("")
    ResponseEntity<Map<String, Object>> getProduits(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size);
}
