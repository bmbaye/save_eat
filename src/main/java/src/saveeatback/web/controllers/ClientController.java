package src.saveeatback.web.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import src.saveeatback.web.dtos.requests.ClientPosted;

import java.util.Map;

@RequestMapping("ap/v1/clients")
public interface ClientController {

    @PostMapping("")
    ResponseEntity<Map<String, Object>> createClient(@RequestBody @Valid ClientPosted clientRequest, BindingResult result);
}
