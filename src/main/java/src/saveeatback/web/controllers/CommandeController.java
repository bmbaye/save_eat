package src.saveeatback.web.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import src.saveeatback.web.dtos.requests.CommandeSubmittedDto;

import java.util.Map;

@RequestMapping(value = "api/v1/commandes")
public interface CommandeController {

    @PostMapping("")
    ResponseEntity<Map<String, Object>> createCmd(@RequestBody @Valid CommandeSubmittedDto commandeDto, BindingResult result);
}
