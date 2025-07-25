package src.saveeatback.web.controllers.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import src.saveeatback.datas.entities.Commande;
import src.saveeatback.datas.entities.Livraison;
import src.saveeatback.datas.entities.Paiement;
import src.saveeatback.services.CommandeService;
import src.saveeatback.services.LivraisonService;
import src.saveeatback.services.PaiementService;
import src.saveeatback.utils.mappers.CommandeMapper;
import src.saveeatback.web.controllers.CommandeController;
import src.saveeatback.web.dtos.requests.CommandeSubmittedDto;
import src.saveeatback.web.dtos.responses.RestResponse;
import src.saveeatback.web.dtos.responses.commandes.CommandeResponse;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CommandeControllerImpl implements CommandeController {

    private final CommandeService commandeService;
    private final PaiementService paiementService;
    private final LivraisonService livraisonService;

    CommandeControllerImpl(CommandeService commandeService, LivraisonService livraisonService, PaiementService paiementService){
        this.commandeService =commandeService;
        this.paiementService = paiementService;
        this.livraisonService = livraisonService;
    }
    @Override
    public ResponseEntity<Map<String, Object>> createCmd(CommandeSubmittedDto commandeDto, BindingResult result) {
        if(result.hasErrors()){
            Map<String, Object> errors = new HashMap<>();
            result.getFieldErrors().forEach(err ->errors.put(err.getField(), err.getDefaultMessage()));
            Map<String, Object> restResponse = RestResponse.response(errors, HttpStatus.NO_CONTENT, "CreationError");

            return new ResponseEntity<>(restResponse, HttpStatus.NO_CONTENT);
        }
        Commande cmd = CommandeMapper.toCommandeEntity(commandeDto);
        Livraison livr = this.livraisonService.create(cmd.getLivraison());
        Paiement pment = this.paiementService.create(cmd.getPaiement());
        cmd.setLivraison(livr);
        cmd.setPaiement(pment);
        Commande response = this.commandeService.create(cmd);

        if(response !=null){
            System.out.println("Okkkkk on y est");
            CommandeResponse cmdResponse = CommandeMapper.toCommandeResponse(cmd);

            Map<String, Object> restResponse = RestResponse.response(cmdResponse, HttpStatus.CREATED, "CommandeResponse");

            return new ResponseEntity<>(restResponse, HttpStatus.CREATED);
        }

        return null;
    }
}
