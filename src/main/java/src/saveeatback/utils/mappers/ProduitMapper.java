package src.saveeatback.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import src.saveeatback.datas.entities.Produit;
import src.saveeatback.datas.enums.ProduitCategorie;
import src.saveeatback.datas.enums.ProduitEtat;
import src.saveeatback.web.dtos.requests.ProduitPosted;
import src.saveeatback.web.dtos.responses.produits.ProduitCreatedResponse;

@Mapper(componentModel = "spring")
public interface ProduitMapper {

    ProduitMapper INSTANCE = Mappers.getMapper(ProduitMapper.class);

    @Mapping(target = "categorie", source = "categorie", qualifiedByName = "mapCategorie")
    @Mapping(target = "etat", source = "etat" , qualifiedByName = "mapEtat")
    @Mapping(target = "images", ignore = true)
    Produit toProduit(ProduitPosted produit);

    @Named("mapCategorie")
    default ProduitCategorie mapCategorie(String categorie) {
        if(categorie == null){
            return null;
        }
        try {
            return ProduitCategorie.valueOf(categorie);
        }catch (IllegalArgumentException e){
            return null;
        }
    }

    @Named("mapEtat")
    default ProduitEtat mapEtat(String etat) {
        if(etat == null){
            return null;
        }
        try {
            return ProduitEtat.valueOf(etat);
        }catch (IllegalArgumentException e){
            return null;
        }
    }

    @Mapping(target = "etat", source = "etat", qualifiedByName = "mapEtatString")
    @Mapping(target = "categorie", source = "categorie", qualifiedByName = "mapCatgorieString")
    ProduitCreatedResponse toProduitCreatedResponse(Produit produit);

    @Named("mapEtatString")
    default String mapEtatString(ProduitEtat etat) {
        if(etat == null){
            return null;
        }
        return etat.name();
    }

    @Named("mapCatgorieString")
    default String mapCatgorieString(ProduitCategorie categorie) {
        if(categorie == null){
            return null;
        }
        return categorie.name();
    }

}
