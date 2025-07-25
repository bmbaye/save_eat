package src.saveeatback.utils.mappers;

import src.saveeatback.datas.entities.Produit;
import src.saveeatback.datas.entities.ProduitCommande;
import src.saveeatback.web.dtos.requests.ProduitCommandeDto;
import src.saveeatback.web.dtos.responses.produits.ProduitCatalogueResponse;
import src.saveeatback.web.dtos.responses.produits.ProduitCmdResponse;
import src.saveeatback.web.dtos.responses.produits.SingleProduitResponse;

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

    public static SingleProduitResponse singleResponse(Produit produit){
        return SingleProduitResponse.builder()
                .setId(produit.getId())
                .setLibelle(produit.getLibelle())
                .setDescription(produit.getDescription())
                .setImage(produit.getImages())
                .setPrix(produit.getPrix())
                .setQteStock(produit.getQteStock())
                .setPromo(produit.getPromo())
                .build();
    }

    public static ProduitCommande toProduitCommandeRequest(ProduitCommandeDto produitCommandeDto){
        ProduitCommande prodCmd = new ProduitCommande();
        prodCmd.setId(produitCommandeDto.getId());
        prodCmd.setQteCommande(produitCommandeDto.getQteCommandee());
        prodCmd.setLibelle(produitCommandeDto.getLibelle());
        prodCmd.setPrix(produitCommandeDto.getPrix());

        return prodCmd;
    }

    public static ProduitCmdResponse toProduitCmdResponse(ProduitCommande produitCommande){
        return ProduitCmdResponse.builder()
                .setId(produitCommande.getId())
                .setLibelle(produitCommande.getLibelle())
                .setPrix(produitCommande.getPrix())
                .setQteCommande(produitCommande.getQteCommande())
                .build();
    }
}
