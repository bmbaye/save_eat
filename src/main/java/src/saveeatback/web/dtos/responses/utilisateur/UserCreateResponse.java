package src.saveeatback.web.dtos.responses.utilisateur;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserCreateResponse {
    private String id;
    private String username;
    private String email;
    private List<String> roles;
}
