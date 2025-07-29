package src.saveeatback.web.controllers.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import src.saveeatback.datas.entities.Utilisateur;
import src.saveeatback.services.UtilisateurService;
import src.saveeatback.utils.mappers.UtilisateurMapper;
import src.saveeatback.web.controllers.UtilisateurController;
import src.saveeatback.web.dtos.requests.UtilisateurPosted;
import src.saveeatback.web.dtos.responses.RestResponse;
import src.saveeatback.web.dtos.responses.utilisateur.UserCreateResponse;

import java.util.HashMap;
import java.util.Map;

@RestController
@Tag(name = "utilisateurs", description = "gestion utilisateurs")
public class UtilisateurControllerImpl implements UtilisateurController {
    private final UtilisateurService userService;
    private final UtilisateurMapper userMapper;

    UtilisateurControllerImpl(UtilisateurService userService, UtilisateurMapper userMapper){
        this.userService =userService;
        this.userMapper = userMapper;
    }


    @Override
    public ResponseEntity<Map<String, Object>> createUser(UtilisateurPosted userRequest, BindingResult result) {
        if(result.hasErrors()){
            Map<String, Object> errors = new HashMap<>();
            result.getFieldErrors().forEach(err ->errors.put(err.getField(), err.getDefaultMessage()));

            Map<String, Object> restResponse = RestResponse.response(errors, HttpStatus.BAD_REQUEST, "errors");
            return new ResponseEntity<>(restResponse,HttpStatus.BAD_REQUEST);
        }

        Utilisateur user = this.userMapper.toUtilisateurEntity(userRequest);
        var userPosted = this.userService.create(user);
        if(userPosted !=null){
            UserCreateResponse userResponse = this.userMapper.toUserCreateResponse(userPosted);
            Map<String, Object> restResponse = RestResponse.response(userResponse, HttpStatus.CREATED, "UserCreateResponse");

            return new ResponseEntity<>(restResponse, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(RestResponse.response("Erreur interne", HttpStatus.INTERNAL_SERVER_ERROR, "ServerError"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
