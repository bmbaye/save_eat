package src.saveeatback.web.controllers.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.jshell.execution.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import src.saveeatback.datas.entities.Livreur;
import src.saveeatback.datas.entities.UserEntity;
import src.saveeatback.datas.entities.Utilisateur;
import src.saveeatback.datas.enums.RoleUser;
import src.saveeatback.services.LivreurService;
import src.saveeatback.services.UtilisateurService;
import src.saveeatback.utils.mappers.LivreurMapper;
import src.saveeatback.web.controllers.LivreurController;
import src.saveeatback.web.dtos.requests.LivreurPosted;
import src.saveeatback.web.dtos.responses.RestResponse;
import src.saveeatback.web.dtos.responses.livreur.LivreurCreateResponse;

import java.util.HashMap;
import java.util.Map;

@RestController
@Tag(name = "livreurs", description = "gestion livreurs")
public class LivreurControllerImpl implements LivreurController {
    private final LivreurService livreurService;
    private final LivreurMapper livreurMapper;
    private final UtilisateurService userService;

    LivreurControllerImpl(LivreurService livreurService, LivreurMapper livreurMapper, UtilisateurService userService){
        this.livreurMapper =livreurMapper;
        this.livreurService =livreurService;
        this.userService =userService;
    }
    @Override
    public ResponseEntity<Map<String, Object>> create(LivreurPosted livreurRequest, BindingResult result) {
        if(result.hasErrors()){
            Map<String, Object> errors = new HashMap<>();
            result.getFieldErrors().stream().map(err -> errors.put(err.getField(), err.getDefaultMessage()));

            Map<String, Object> restResponse = RestResponse.response(errors, HttpStatus.BAD_REQUEST, "errors");

            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        Livreur livreur = this.livreurMapper.toLivreurEntity(livreurRequest);

        Utilisateur user =new Utilisateur();

//        user.setRole(RoleUser.LIVREUR);
        user.setUsername(livreur.getUser().getUsername());
        user.setPassword(livreur.getUser().getPassword());

        Utilisateur userAdded = this.userService.create(user);

        UserEntity userEntity = new UserEntity();
        userEntity.setPassword(userAdded.getPassword());
        userEntity.setUsername(userAdded.getUsername());
        userEntity.setUserID(userAdded.getId());

        livreur.setUser(userEntity);

        Livreur livreurAdded = this.livreurService.create(livreur);

        LivreurCreateResponse livreurResponseDto = this.livreurMapper.toLivreurCreateResponse(livreurAdded);

        Map<String,Object> restResponse = RestResponse.response(livreurResponseDto, HttpStatus.CREATED, "LivreurCreateResponse");

        return new ResponseEntity<>(restResponse, HttpStatus.CREATED);
    }
}
