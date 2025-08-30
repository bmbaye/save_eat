package src.saveeatback.controllers.impl;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;
import src.saveeatback.controllers.AuthController;
import src.saveeatback.datas.entities.Utilisateur;
import src.saveeatback.datas.repositories.UtilisateurRepository;
import src.saveeatback.security.JwtUtils;
import src.saveeatback.security.UserDetailsImpl;
import src.saveeatback.utils.mappers.UtilisateurMapper;
import src.saveeatback.web.dtos.requests.LoginRequest;
import src.saveeatback.web.dtos.requests.SignupRequest;
import src.saveeatback.web.dtos.responses.RestResponse;
import src.saveeatback.web.dtos.responses.jwt.JwtResponse;

import java.util.*;

@RestController
public class AuthControllerImpl implements AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UtilisateurMapper userMapper;

    @Autowired
    UtilisateurRepository userRepository;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public ResponseEntity<Map<String,Object>> authenticate(LoginRequest loginRequest){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        String jwtToken = jwtUtils.generateToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).toList();
        JwtResponse jwtResponse = JwtResponse.builder()
                .setEmail(userDetails.getEmail())
                .setId(userDetails.getId())
                .setToken(jwtToken)
                .setRoles(roles)
                .setUsername(userDetails.getUsername())
                .build();

        Map<String,Object> response = RestResponse.response(jwtResponse, HttpStatus.OK, "jwtResponse");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> register(SignupRequest signupRequest) {
        if(userRepository.existsByUsername(signupRequest.getUsername())) {
            Map<String,Object> response = RestResponse.response("Un utilisateur porte deja ce nom !", HttpStatus.BAD_REQUEST, "ErrorSignup");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signupRequest.getEmail())) {
            Map<String, Object> response = RestResponse.response("Cet email appartient a un utilisateur !", HttpStatus.BAD_REQUEST, "ErrorSignup");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        Set<String> roles = new HashSet<>();
        signupRequest.getRoles().stream().map(roles::add);


        Utilisateur user =new Utilisateur(signupRequest.getUsername(),signupRequest.getEmail(),encoder.encode(signupRequest.getPassword()),roles);
        Map<String,Object> response = RestResponse.response(userRepository.save(user),HttpStatus.CREATED,"userSignup");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
