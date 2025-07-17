package src.saveeatback.utils.mappers;

import src.saveeatback.datas.entities.Produit;
import src.saveeatback.web.dtos.responses.produits.ProduitCatalogueResponse;

public class ProduitMapper {

    public static ProduitCatalogueResponse responseCatlogue(Produit produit){
        return ProduitCatalogueResponse.builder()
                .setId(produit.getId())
                .setLibelle(produit.getLibelle())
                .setDescription(produit.getDescription())
                .setImage(produit.getImages()[0])
                .setPrix(produit.getPrix())
                .setQteStock(produit.getQteStock())
                .setPromo(produit.getPromo())
                .build();
    }
}
