package src.saveeatback.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import src.saveeatback.datas.entities.BoxSaveEat;

import java.util.Map;

@RequestMapping("api/v1")
public interface BoxSaveEatController {
    @GetMapping("/box-save-eat")
    ResponseEntity<Map<String, Object>> getBoxSaveEat();


}
