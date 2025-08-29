package src.saveeatback.web.dtos.responses.jwt;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtResponse {
    private String token;
    private String type;
    private String id;
    private String username;
    private String email;
    private List<String> roles;

    public static class Builder{
        private String token;
        private String type = "Bearer";
        private String id;
        private String username;
        private String email;
        private List<String> roles;

        public Builder setToken(String token){
            this.token = token;
            return this;
        }
        public Builder setType(String type){
            this.type = type;
            return this;
        }
        public Builder setId(String id){
            this.id = id;
            return this;
        }
        public Builder setUsername(String username){
            this.username = username;
            return this;
        }
        public Builder setEmail(String email){
            this.email = email;
            return this;
        }
        public Builder setRoles(List<String> roles){
            this.roles = roles;
            return this;
        }

        public JwtResponse build(){return new JwtResponse(this);}
    }

    public static Builder builder(){return new Builder();}

    JwtResponse(Builder builder){
        this.token = builder.token;
        this.type = builder.type;
        this.id = builder.id;
        this.username = builder.username;
        this.email = builder.email;
        this.roles = builder.roles;
    }
}
