package src.saveeatback.web.dtos.responses.utilisateur;

import lombok.Getter;

@Getter
public class UserCreateResponse {
    private String idUser;
    private String username;
    private String message;

    public static class Builder{
        private String idUser;
        private String username;
        private String message;

        public Builder setIdUser(String idUser) {
            this.idUser = idUser;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public UserCreateResponse build(){return new UserCreateResponse(this);}
    }

    public static Builder builder(){return new Builder();}

    public UserCreateResponse(Builder builder){
        this.idUser = builder.idUser;
        this.username = builder.username;
        this.message = builder.message;
    }
}
