package src.saveeatback.web.dtos.responses.client;


public class ClientCreateResponse {
    private String id;
    private String nomComplet;
    private String username;
    private String telephone;
    private String adresse;
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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
