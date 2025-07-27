package src.saveeatback.web.dtos.responses.client;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientCreateResponse {
    private String id;
    private String nomComplet;
    private String username;
    private String telephone;
    private String adresse;
    private String message;

    public static class Builder{
        private String id;
        private String nomComplet;
        private String username;
        private String telephone;
        private String adresse;
        private String message;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setNomComplet(String nomComplet) {
            this.nomComplet = nomComplet;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setTelephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public Builder setAdresse(String adresse) {
            this.adresse = adresse;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public ClientCreateResponse build(){return new ClientCreateResponse(this);}

    }

    public static Builder builder(){return new Builder();}

    ClientCreateResponse(Builder builder){
        this.id = builder.id;
        this.nomComplet = builder.nomComplet;
        this.username = builder.username;
        this.telephone = builder.telephone;
        this.adresse = builder.adresse;
        this.message = builder.message;
    }
}
