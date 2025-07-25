package src.saveeatback.datas.entities;

import ch.qos.logback.core.net.server.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import src.saveeatback.datas.enums.EtatPaiement;
import src.saveeatback.datas.enums.TypePaiement;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "paiements")
public class Paiement {
    @Id
    private String id;
    private TypePaiement type;
    private Double montant;
    private EtatPaiement etat = EtatPaiement.A_EFFECTUER;
    private Date dateEffectuee;

}
