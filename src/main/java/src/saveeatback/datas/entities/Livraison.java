package src.saveeatback.datas.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import src.saveeatback.datas.enums.EtatLivraison;
import src.saveeatback.datas.enums.HoraireLivraison;
import src.saveeatback.datas.enums.TypeLivraison;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "livraisons")
public class Livraison {
    @Id
    private String id;

    @DBRef
    private Livreur livreur;

    private TypeLivraison type;

    private Date dateLivraison;

    private HoraireLivraison horaire;

    private EtatLivraison etat;

    private String ville;

    private String rue;
}
