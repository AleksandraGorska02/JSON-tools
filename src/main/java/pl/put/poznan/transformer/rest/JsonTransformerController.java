package pl.put.poznan.transformer.rest;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.*;

import java.util.Map;


/**
 * Spring controller class responsible for handling HTTP requests
 * related to JSON transformation.
 */
@RestController
public class JsonTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(JsonTransformerController.class);

    /**
     * GET Endpoint for JSON Component
     * This method handles HTTP GET requests at the root path ("/")
     * and expects both the request and response to be in JSON format
     * It creates a 'JsonComponent' object based on the provided JSON data and returns it.
     * @param json JSON data
     * @return JsonComponent
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public JsonComponent get(@RequestBody Map<String,Object> json) {

        JsonComponent jsonComponent = new JsonComponent(json);
        return jsonComponent;

    }

    /**
     * GET Endpoint for minification transformation
     * This method handles HTTP GET requests at the "/mini" path
     * It takes a JSON string as input, minifies and returns transformed JSON as a string
     * @param json JSON data
     * @return minified JSON data
     * @throws JsonProcessingException thrown if invalid JSON format
     */
    @RequestMapping(value ="/mini", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public String getMini(@RequestBody String json) throws JsonProcessingException {
        JsonComponent jsonComponent = new JsonComponent(json);
        JsonDecorator jsonDecorator = new JsonMini(jsonComponent);
        return jsonDecorator.getJson().toString();
    }

    /**
     * GET Endpoint for expansion transformation
     * This method handles HTTP GET requests at the "/expand" path
     * It takes a JSON string as input, expand and returns transformed JSON as a string
     * @param json JSON data
     * @return expand JSON data
     * @throws JsonProcessingException thrown if invalid JSON format
     */
    @RequestMapping(value ="/expand", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public String getExpand(@RequestBody String json) throws JsonProcessingException {
        JsonComponent jsonComponent = new JsonComponent(json);
        JsonDecorator jsonDecorator = new JsonExpand(jsonComponent);
        return jsonDecorator.getJson().toString();
    }

    /**
     * GET Endpoint for removing transformation
     * This method handles HTTP GET requests at the "/remove" path
     * It takes a JSON string as input, remove the given keys and returns transformed JSON as a string
     * @param json JSON data
     * @return JSON data with removed keys
     * @throws JsonProcessingException thrown if invalid JSON format
     */
    @RequestMapping(value ="/remove", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public String getRemove(@RequestBody String json) throws JsonProcessingException {
        JsonComponent jsonComponent = new JsonComponent(json);
        JsonDecorator jsonDecorator = new JsonRemove(jsonComponent);
        return jsonDecorator.getJson().toString();
    }

    /**
     * POST Endpoint for JSON Data
     * This method handles HTTP POST requests.
     * @param json JSON data
     * @return JSON data
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json",consumes = "application/json")
    public Object post(@RequestBody Map<String, Object> json) {


        return json;
    }



}


