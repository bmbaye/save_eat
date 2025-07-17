package src.saveeatback.datas.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import src.saveeatback.datas.enums.ProduitCategorie;
import src.saveeatback.datas.enums.ProduitEtat;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "produits")
public class Produit {
    @Id
    private String id;
    private String libelle;
    private Double prix;
    private Integer qteStock;
    private String description;
    private String[] images;
    private ProduitCategorie categorie;
    private ProduitEtat etat;
    private LocalDateTime dateExpiration;
    private boolean promo;
}
