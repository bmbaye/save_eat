package src.saveeatback.web.controllers.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import src.saveeatback.datas.entities.Produit;
import src.saveeatback.exceptions.EntityNotFoundException;
import src.saveeatback.services.ProduitService;
import src.saveeatback.services.impl.ProduitServiceImpl;
import src.saveeatback.utils.mappers.ProduitMapper;
import src.saveeatback.web.controllers.ProduitController;
import src.saveeatback.web.dtos.responses.RestResponse;
import src.saveeatback.web.dtos.responses.produits.ProduitCatalogueResponse;
import src.saveeatback.web.dtos.responses.produits.SingleProduitResponse;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Tag(name = "produits", description = "gestion produits")
public class ProduitControllerImpl implements ProduitController {

    private final ProduitService produitService;
    private final ProduitMapper produitMapper;

    public ProduitControllerImpl(ProduitService produitService,ProduitMapper produitMapper){
        this.produitService =produitService;
        this.produitMapper = produitMapper;
    }

    @Override
    public ResponseEntity<Map<String, Object>> getProduits(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        var produits = this.produitService.getProduits(pageable);
        List<ProduitCatalogueResponse> produitDtos = produits.map(this.produitMapper::responseCatlogue).toList();

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

    @Override
    public ResponseEntity<Map<String, Object>> getOneById(String id) {
        Optional<Produit> produit = produitService.getOneProduit(id);
        if(produit.isPresent()){
            SingleProduitResponse produitDto = this.produitMapper.singleResponse(produit.get());

            Map<String, Object> restResonse = RestResponse.response(produitDto,HttpStatus.OK,"SingleProduitResponse");
            return new ResponseEntity<>(restResonse, HttpStatus.OK);
        }
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> getOneByLibelle(String libelle) {
        Optional<Produit> produit = produitService.getByLibelle(libelle);
        if(produit.isPresent()){
            SingleProduitResponse produitDto = this.produitMapper.singleResponse(produit.get());

            Map<String, Object> restResponse = RestResponse.response(produitDto, HttpStatus.OK, "SingleProduitResponse");

            return new ResponseEntity<>(restResponse, HttpStatus.OK);
        }

        Object result  = new EntityNotFoundException("Aucun produit ne porte ce libelle").getMessage();
        Map<String, Object> response = RestResponse.response(result, HttpStatus.NOT_FOUND, "EntityNotFoundException");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
