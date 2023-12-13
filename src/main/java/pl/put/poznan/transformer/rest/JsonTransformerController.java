package pl.put.poznan.transformer.rest;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.*;

import java.util.Map;


@RestController

public class JsonTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(JsonTransformerController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public JsonComponent get(@RequestBody Map<String,Object> json) {

        JsonComponent jsonComponent = new JsonComponent(json);
        return jsonComponent;

    }
    @RequestMapping(value ="/mini", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public String getMini(@RequestBody String json) throws JsonProcessingException {
        JsonComponent jsonComponent = new JsonComponent(json);
        JsonDecorator jsonDecorator = new JsonMini(jsonComponent);
        return jsonDecorator.getJson().toString();
    }
    @RequestMapping(value ="/expand", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public String getExpand(@RequestBody String json) throws JsonProcessingException {
        JsonComponent jsonComponent = new JsonComponent(json);
        JsonDecorator jsonDecorator = new JsonExpand(jsonComponent);
        return jsonDecorator.getJson().toString();
    }
    @RequestMapping(value ="/remove", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public String getRemove(@RequestBody String json) throws JsonProcessingException {
        JsonComponent jsonComponent = new JsonComponent(json);
        JsonDecorator jsonDecorator = new JsonRemove(jsonComponent);
        return jsonDecorator.getJson().toString();
    }
    @RequestMapping(method = RequestMethod.POST, produces = "application/json",consumes = "application/json")
    public Object post(@RequestBody Map<String, Object> json) {


        return json;
    }



}


