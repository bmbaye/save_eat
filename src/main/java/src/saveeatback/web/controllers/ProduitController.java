package src.saveeatback.web.controllers;

import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import src.saveeatback.web.dtos.requests.ProduitPosted;

import java.util.Map;

@RequestMapping(value = "api/v1/produits")
public interface ProduitController {
    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<Map<String, Object>> createProduit(@ModelAttribute @Valid ProduitPosted produit, BindingResult bindingResult);
    @GetMapping("")
    ResponseEntity<Map<String, Object>> getProduits(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size);

    @GetMapping("/one/{id}")
    ResponseEntity<Map<String, Object>> getOneById(@PathVariable(name = "id") String id);

    @GetMapping("/one/")
    ResponseEntity<Map<String, Object>> getOneByLibelle(@RequestParam String libelle);

}
