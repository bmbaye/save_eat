package src.saveeatback.web.controllers.impl;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import src.saveeatback.datas.entities.Produit;
import src.saveeatback.services.ProduitService;
import src.saveeatback.services.impl.ProduitServiceImpl;
import src.saveeatback.utils.mappers.ProduitMapper;
import src.saveeatback.web.controllers.ProduitController;
import src.saveeatback.web.dtos.responses.RestResponse;
import src.saveeatback.web.dtos.responses.produits.ProduitCatalogueResponse;

import java.util.List;
import java.util.Map;

@RestController
public class ProduitControllerImpl implements ProduitController {

    private final ProduitService produitService;

    public ProduitControllerImpl(ProduitService produitService){
        this.produitService =produitService;
    }

    @Override
    public ResponseEntity<Map<String, Object>> getProduits(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        var produits = this.produitService.getProduits(pageable);
        List<ProduitCatalogueResponse> produitDtos = produits.map(ProduitMapper::responseCatlogue).toList();

        int totalPages = produits.getTotalPages();
        Map<String, Object> produitsRestResponse = RestResponse.paginatedResponse(
                HttpStatus.OK,
                produitDtos,
                new int[totalPages],
                produits.getPageable().getPageNumber(),
                totalPages,
                produits.getTotalElements(),
                produits.isFirst(),
                produits.isLast(),
                "ProduitCatalogueResponse"
        );

        return new ResponseEntity<>(produitsRestResponse, HttpStatus.OK);
    }
}
