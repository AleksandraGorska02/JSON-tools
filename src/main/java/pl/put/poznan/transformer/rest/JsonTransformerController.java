package pl.put.poznan.transformer.rest;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.JsonComponent;
import pl.put.poznan.transformer.logic.JsonDecorator;
import pl.put.poznan.transformer.logic.JsonRemove;

import java.util.Map;


@RestController

public class JsonTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(JsonTransformerController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public String get(@RequestBody String json) {
        return String.valueOf(new JsonComponent(json));

    }
    @RequestMapping(value ="/remove", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public String getRemove(@RequestBody String json) throws JsonProcessingException {
        JsonComponent jsonComponent = new JsonComponent(json);
        JsonDecorator jsonDecorator = new JsonRemove(jsonComponent);
        return jsonDecorator.getJson();
    }
    @RequestMapping(method = RequestMethod.POST, produces = "application/json",consumes = "application/json")
    public Object post(@RequestBody Map<String, Object> json) {


        return json;
    }



}


