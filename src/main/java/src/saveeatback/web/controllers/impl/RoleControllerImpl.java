package src.saveeatback.web.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import src.saveeatback.datas.entities.Role;
import src.saveeatback.services.RoleService;
import src.saveeatback.utils.mappers.RoleMapper;
import src.saveeatback.web.controllers.RoleController;
import src.saveeatback.web.dtos.requests.RolePosted;
import src.saveeatback.web.dtos.responses.RestResponse;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RoleControllerImpl implements RoleController {

    private final RoleService roleService;
    @Autowired
    private RoleMapper roleMapper;

    RoleControllerImpl(RoleService roleService) {
        this.roleService = roleService;
    }
    @Override
    public ResponseEntity<Map<String, Object>> createRole(RolePosted rolePosted, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, Object> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(err ->errors.put(err.getField(), err.getDefaultMessage()));

            Map<String, Object> restResponse = RestResponse.response(errors, HttpStatus.BAD_REQUEST, "errors");
            return new ResponseEntity<>(restResponse,HttpStatus.BAD_REQUEST);
        }

        Role role = roleMapper.toRole(rolePosted);
        Role roleAdded = this.roleService.createRole(role);
        if(roleAdded != null){
            Map<String, Object> restResponse = RestResponse.response("role"  + roleAdded.getNomRole() + "ajoute avec succes", HttpStatus.CREATED, "role created");
            return new ResponseEntity<>(restResponse,HttpStatus.CREATED);
        }

        return new ResponseEntity<>(RestResponse.response("Erreur interne", HttpStatus.INTERNAL_SERVER_ERROR, "ServerError"), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
