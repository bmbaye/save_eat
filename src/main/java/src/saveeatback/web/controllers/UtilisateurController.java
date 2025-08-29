package src.saveeatback.web.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import src.saveeatback.web.dtos.requests.SignupRequest;

import java.util.Map;

@RequestMapping(value = "api/v1/utilisateurs")
public interface UtilisateurController {
    @PostMapping("")
    ResponseEntity<Map<String, Object>> createUser(@RequestBody @Valid SignupRequest userRequest, BindingResult result);

}
