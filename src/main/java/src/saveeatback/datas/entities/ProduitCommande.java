package src.saveeatback.datas.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import src.saveeatback.datas.enums.ProduitEtat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProduitCommande {
    private String id;
    private String libelle;
    private Double prix;
    private int qteCommande;
    private ProduitEtat etat;
}
