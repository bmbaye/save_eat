package src.saveeatback.utils.mappers;

import org.springframework.stereotype.Component;
import src.saveeatback.datas.entities.Livreur;
import src.saveeatback.datas.entities.UserEntity;
import src.saveeatback.web.dtos.requests.LivreurPosted;
import src.saveeatback.web.dtos.responses.livreur.LivreurCreateResponse;

@Component
public class LivreurMapper {

    public Livreur toLivreurEntity(LivreurPosted livreurRequest){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(livreurRequest.getUsername());
        userEntity.setPassword(livreurRequest.getPassword());


        Livreur livreur = new Livreur();
        livreur.setNom(livreurRequest.getNom());
        livreur.setPrenom(livreurRequest.getPrenom());
        livreur.setTelephone(livreurRequest.getTelephone());
        livreur.setImage(livreurRequest.getImage());
        livreur.setAdresse(livreurRequest.getAdresse());
        livreur.setUser(userEntity);

        return livreur;

    }

    public LivreurCreateResponse toLivreurCreateResponse(Livreur livreur){
        return LivreurCreateResponse.builder()
                .setId(livreur.getId())
                .setNomComplet(livreur.getPrenom() + " " + livreur.getNom())
                .setTelephone(livreur.getTelephone())
                .setUsername(livreur.getUser().getUsername())
                .setAdresse(livreur.getAdresse())
                .setMessage("Client cree avec succes")
                .build();
    }
}
