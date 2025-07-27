package src.saveeatback.web.controllers.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import src.saveeatback.datas.entities.BoxSaveEat;
import src.saveeatback.services.BoxSaveService;
import src.saveeatback.utils.mappers.BoxMapper;
import src.saveeatback.web.controllers.BoxSaveEatController;
import src.saveeatback.web.dtos.responses.RestResponse;
import src.saveeatback.web.dtos.responses.box.BoxSaveEatResponse;

import java.util.Map;

@RestController
public class BoxSaveEatControllerImpl implements BoxSaveEatController {
    private final BoxSaveService boxService;
    private final BoxMapper boxMapper;

    public BoxSaveEatControllerImpl(BoxSaveService boxService, BoxMapper boxMapper){
        this.boxMapper = boxMapper;
        this.boxService = boxService;
    }

    @Override
    public ResponseEntity<Map<String, Object>> getBoxSaveEat() {
        BoxSaveEat box = this.boxService.getBoxSaveEat();

        BoxSaveEatResponse boxResponse = this.boxMapper.toBoxResponse(box);

        Map<String, Object> restResponse = RestResponse.response(boxResponse, HttpStatus.OK, "BoxSaveEatResponse");

        return new ResponseEntity<>(restResponse, HttpStatus.OK);
    }
}
