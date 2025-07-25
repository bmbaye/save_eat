package src.saveeatback.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

@RequestMapping(value = "api/v1/produits")
public interface ProduitController {
    @GetMapping("")
    ResponseEntity<Map<String, Object>> getProduits(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size);

    @GetMapping("/one/{id}")
    ResponseEntity<Map<String, Object>> getOneById(@PathVariable(name = "id") String id);

    @GetMapping("/one/")
    ResponseEntity<Map<String, Object>> getOneByLibelle(@RequestParam String libelle);

}
