package src.saveeatback.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import src.saveeatback.web.dtos.requests.LoginRequest;
import src.saveeatback.web.dtos.requests.SignupRequest;

import java.util.Map;

@RequestMapping("api/v1/auth")
public interface AuthController {

    @PostMapping("/login")
    ResponseEntity<Map<String,Object>> authenticate(@RequestBody @Valid LoginRequest loginRequest);

    @PostMapping("/signup")
    ResponseEntity<Map<String,Object>> register(@RequestBody @Valid SignupRequest signupRequest);
    @GetMapping("/verify")
    public ResponseEntity<String> verify();
}
