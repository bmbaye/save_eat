package src.saveeatback.web.dtos.responses;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class RestResponse {

    public static Map<String, Object> response(Object results, HttpStatus code, String type){
        Map<String, Object> response = new HashMap<>();

        response.put("resultats", results);
        response.put("status", code);
        response.put("type", type);
        return response;
    }

    public static Map<String, Object> paginatedResponse(HttpStatus code,Object results, int[] pages, Integer currentPage, Integer toltalPages, Long totalItems, Boolean firstPage, Boolean lastPage, String type){
        Map<String, Object> response = new HashMap<>();

        response.put("resultats", results);
        response.put("currentPage", currentPage);
        response.put("pages", pages);
        response.put("totalPages", toltalPages);
        response.put("totalItems", totalItems);
        response.put("firstPage", firstPage);
        response.put("lastPage", lastPage);
        response.put("type", type);

        return response;
    }
}
