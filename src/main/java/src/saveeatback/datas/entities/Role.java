package src.saveeatback.datas.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import src.saveeatback.datas.enums.RoleUser;

@Getter
@Setter
@Document(collection = "roles")
public class Role {
    @Id
    private String id;
    private String nomRole;

    Role(RoleUser roleUSer){
        this.nomRole = roleUSer.name();
    }
}
