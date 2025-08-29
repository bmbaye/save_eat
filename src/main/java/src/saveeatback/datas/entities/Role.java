package src.saveeatback.datas.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import src.saveeatback.datas.enums.RoleUser;


@Document(collection = "roles")
public class Role {
    @Id
    private String id;
    private String nomRole;

    Role(RoleUser roleUSer){
        this.nomRole = roleUSer.name();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomRole() {
        return nomRole;
    }

    public void setNomRole(String nomRole) {
        this.nomRole = nomRole;
    }
}
