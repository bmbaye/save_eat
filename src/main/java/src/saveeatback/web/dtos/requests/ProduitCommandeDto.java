package src.saveeatback.web.dtos.requests;


public class ProduitCommandeDto {
    private String id;
    private String libelle;
    private Double prix;
    private Integer qteCommandee;

    public String getId() {
        return id;
    }

    public Integer getQteCommandee() {
        return qteCommandee;
    }

    public Double getPrix() {
        return prix;
    }

    public String getLibelle() {
        return libelle;
    }
}
