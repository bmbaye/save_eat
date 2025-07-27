package src.saveeatback.utils.mappers;

import org.springframework.stereotype.Component;
import src.saveeatback.datas.entities.BoxSaveEat;
import src.saveeatback.web.dtos.responses.box.BoxSaveEatResponse;

@Component
public class BoxMapper {

    public BoxSaveEatResponse toBoxResponse(BoxSaveEat boxSaveEat){
        return BoxSaveEatResponse.builder()
                .setProduits(boxSaveEat.getProduits())
                .setPoids(boxSaveEat.getPoids())
                .setPrix(boxSaveEat.getPrix())
                .build();
    }
}
