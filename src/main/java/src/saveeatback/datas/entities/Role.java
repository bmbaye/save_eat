package src.saveeatback.datas.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import src.saveeatback.datas.enums.RoleUser;


@Document(collection = "roles")
public class Role {
    @Id
    private String id;
    private String nomRole;

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

    public Role() {
    }
    public Role(String id, String nomRole) {
        this.id = id;
        this.nomRole = nomRole;
    }
}
