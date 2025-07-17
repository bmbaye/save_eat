package src.saveeatback.datas.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "clients")
public class Cient {
    private String nom;
    private String prenom;
    private String telephone;
    private String login;
    private String password;
    private String ville;
    private String rue;
    private String image;
}
