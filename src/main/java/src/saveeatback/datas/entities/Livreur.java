package src.saveeatback.datas.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "livreurs")
public class Livreur {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String telephone;
    private String adresse;
    private String image;
}
