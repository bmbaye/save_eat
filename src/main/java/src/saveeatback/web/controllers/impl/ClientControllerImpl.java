package src.saveeatback.web.controllers.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import src.saveeatback.datas.entities.Client;
import src.saveeatback.datas.entities.UserEntity;
import src.saveeatback.datas.entities.Utilisateur;
import src.saveeatback.services.ClientService;
import src.saveeatback.services.UtilisateurService;
import src.saveeatback.web.controllers.ClientController;
import src.saveeatback.web.dtos.requests.ClientPosted;
import src.saveeatback.web.dtos.responses.RestResponse;
import src.saveeatback.web.dtos.responses.client.ClientCreateResponse;

import java.util.HashMap;
import java.util.Map;

@RestController
@Tag(name = "clients", description = "gestion clients")
public class ClientControllerImpl implements ClientController {
//    private final ClientMapper clientMapper;
    private final ClientService clientService;
    private final UtilisateurService utilisateurService;

    ClientControllerImpl(ClientService clientService, UtilisateurService utilisateurService ){
        this.utilisateurService =utilisateurService;
        this.clientService =clientService;
    }

    @Override
    public ResponseEntity<Map<String, Object>> createClient(ClientPosted clientRequest, BindingResult result) {
        if(result.hasErrors()){
            Map<String, Object> errors = new HashMap<>();
            result.getFieldErrors().stream().map(err -> errors.put(err.getField(), err.getDefaultMessage()));

            Map<String, Object> restResponse = RestResponse.response(errors, HttpStatus.BAD_REQUEST, "errors");
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

//        Client client = this.clientMapper.toClientEntity(clientRequest);

        Utilisateur user = new Utilisateur();
//        user.setUsername(client.getUser().getUsername());
//        user.setPassword(client.getUser().getPassword());
//        user.setRoles(RoleUser.CLIENT);

        Utilisateur userPosted = this.utilisateurService.create(user);

        UserEntity userEntity = new UserEntity();
        userEntity.setUserID(userPosted.getId());
        userEntity.setUsername(userPosted.getUsername());
        userEntity.setPassword(userPosted.getPassword());

//        client.setUser(userEntity);

//        Client clientPosted = this.clientService.create(client);

//        ClientCreateResponse clientResponse = clientMapper.toClientCreateResponse(clientPosted);

        Map<String,Object> restResponse = RestResponse.response("clientResponse", HttpStatus.CREATED, "ClientCreateResponse");

        return new ResponseEntity<>(restResponse, HttpStatus.CREATED);
    }
}
