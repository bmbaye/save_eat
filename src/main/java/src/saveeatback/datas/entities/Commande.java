package src.saveeatback.datas.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import src.saveeatback.datas.enums.EtatCommande;
import src.saveeatback.datas.enums.TypePaiement;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "commandes")
public class Commande {
    @Id
    private String id;

    private Double montant;

    @DBRef
    private List<ProduitCommande> produits;

    private EtatCommande etatCommande;

    private TypePaiement typePaiement;

    private Integer nombrePoduits;

    @DBRef
    private Livraison livraison;

    @DBRef
    private Cient client;
}
