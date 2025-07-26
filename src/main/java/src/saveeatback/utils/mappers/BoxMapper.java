package src.saveeatback.utils.mappers;

import src.saveeatback.datas.entities.BoxSaveEat;
import src.saveeatback.web.dtos.responses.box.BoxSaveEatResponse;

public class BoxMapper {

    public static BoxSaveEatResponse toBoxResponse(BoxSaveEat boxSaveEat){
        return BoxSaveEatResponse.builder()
                .setProduits(boxSaveEat.getProduits())
                .setPoids(boxSaveEat.getPoids())
                .setPrix(boxSaveEat.getPrix())
                .build();
    }
}
