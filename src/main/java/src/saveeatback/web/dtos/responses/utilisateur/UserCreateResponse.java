package src.saveeatback.web.dtos.responses.utilisateur;


import java.util.List;


public class UserCreateResponse {
    private String id;
    private String username;
    private String email;
    private List<String> roles;

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public UserCreateResponse(String id, String username, String email, List<String> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
