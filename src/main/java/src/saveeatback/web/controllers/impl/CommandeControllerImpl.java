package src.saveeatback.web.controllers.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import src.saveeatback.datas.entities.*;
import src.saveeatback.services.CommandeService;
import src.saveeatback.services.LivraisonService;
import src.saveeatback.services.PaiementService;
import src.saveeatback.utils.mappers.CommandeMapper;
import src.saveeatback.web.controllers.CommandeController;
import src.saveeatback.web.dtos.requests.CommandeSubmittedDto;
import src.saveeatback.web.dtos.responses.RestResponse;
import src.saveeatback.web.dtos.responses.commandes.CommandeResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "commandes", description = "gestion commandes")
public class CommandeControllerImpl implements CommandeController {

    private final CommandeService commandeService;
    private final PaiementService paiementService;
    private final LivraisonService livraisonService;
    private final CommandeMapper commandeMapper;

    CommandeControllerImpl(CommandeService commandeService, LivraisonService livraisonService, PaiementService paiementService, CommandeMapper commandeMapper){
        this.commandeService =commandeService;
        this.paiementService = paiementService;
        this.livraisonService = livraisonService;
        this.commandeMapper = commandeMapper;
    }
    @Override
    public ResponseEntity<Map<String, Object>> createCmd(CommandeSubmittedDto commandeDto, BindingResult result) {
        if(result.hasErrors()){
            Map<String, Object> errors = new HashMap<>();
            result.getFieldErrors().forEach(err ->errors.put(err.getField(), err.getDefaultMessage()));
            Map<String, Object> restResponse = RestResponse.response(errors, HttpStatus.BAD_REQUEST, "CreationError");

            return new ResponseEntity<>(restResponse, HttpStatus.BAD_REQUEST);
        }
        Commande cmd = this.commandeMapper.toCommandeEntity(commandeDto);
        Livraison livr = this.livraisonService.create(cmd.getLivraison());
        Paiement pment = this.paiementService.create(cmd.getPaiement());
        cmd.setLivraison(livr);
        cmd.setPaiement(pment);
        Commande response = this.commandeService.create(cmd);

        if(response !=null){
            System.out.println("Okkkkk on y est");
            CommandeResponse cmdResponse = this.commandeMapper.toCommandeResponse(cmd);

            Map<String, Object> restResponse = RestResponse.response(cmdResponse, HttpStatus.CREATED, "CommandeResponse");

            return new ResponseEntity<>(restResponse, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(RestResponse.response("Erreur interne", HttpStatus.INTERNAL_SERVER_ERROR, "ServerError"), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
