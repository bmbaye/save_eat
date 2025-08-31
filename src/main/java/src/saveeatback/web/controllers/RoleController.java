package src.saveeatback.web.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import src.saveeatback.web.dtos.requests.RolePosted;

import java.util.Map;

@RequestMapping("api/v1/roles")
public interface RoleController {

    @PostMapping("")
    ResponseEntity<Map<String, Object>> createRole(@RequestBody @Valid RolePosted role, BindingResult bindingResult);
}
