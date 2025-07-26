package src.saveeatback.datas.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BoxSaveEat {
    private List<ProduitBox> produits;
    private Double prix;
    private Double poids;
}
