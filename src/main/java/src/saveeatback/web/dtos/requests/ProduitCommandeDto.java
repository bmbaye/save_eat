package src.saveeatback.web.dtos.requests;

import lombok.Getter;

@Getter
public class ProduitCommandeDto {
    private String id;
    private String libelle;
    private Double prix;
    private Integer qteCommandee;
}
