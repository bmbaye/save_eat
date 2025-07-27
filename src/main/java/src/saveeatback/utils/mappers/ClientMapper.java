package src.saveeatback.utils.mappers;

import org.springframework.stereotype.Component;
import src.saveeatback.datas.entities.Client;
import src.saveeatback.datas.entities.UserEntity;
import src.saveeatback.datas.entities.Utilisateur;
import src.saveeatback.web.dtos.requests.ClientPosted;
import src.saveeatback.web.dtos.responses.client.ClientCreateResponse;

@Component
public class ClientMapper {

    private final UtilisateurMapper userMapper;

    ClientMapper(UtilisateurMapper userMapper){
        this.userMapper = userMapper;
    }

    public ClientCreateResponse toClientCreateResponse(Client client){
        return ClientCreateResponse.builder()
                .setId(client.getId())
                .setNomComplet(client.getPrenom() + " " + client.getNom())
                .setTelephone(client.getTelephone())
                .setUsername(client.getUser().getUsername())
                .setAdresse(client.getVille() + " " + client.getRue())
                .setMessage("Client cree avec succes")
                .build();
    }

    public Client toClientEntity(ClientPosted clientRequest){
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword(clientRequest.getPassword());
        userEntity.setUsername(clientRequest.getUsername());

        Client client = new Client();
        client.setNom(clientRequest.getNom());
        client.setPrenom(clientRequest.getPrenom());
        client.setTelephone(clientRequest.getTelephone());
        client.setRue(clientRequest.getRue());
        client.setVille(clientRequest.getVille());
        client.setImage(clientRequest.getImage());
        client.setUser(userEntity);
        return client;
    }
}
