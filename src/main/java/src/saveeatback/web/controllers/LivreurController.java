package src.saveeatback.web.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import src.saveeatback.web.dtos.requests.LivreurPosted;

import java.util.Map;

@RequestMapping(value = "api/v1/livreurs")
public interface LivreurController {

    @PostMapping("")
    ResponseEntity<Map<String, Object>> create(@RequestBody @Valid LivreurPosted livreur, BindingResult result);
}
