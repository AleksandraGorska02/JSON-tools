package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class is a concrete decorator for a decorator pattern
 */
public class JsonMini extends JsonDecorator{

    /**
     * Class constructor
     * @param jsonComponent component object
     * @throws JsonProcessingException thrown if invalid JSON format
     */
    public JsonMini(JsonComponent jsonComponent) throws JsonProcessingException {
        super(jsonComponent);

    }


    /**
     * This method returns minified JSON
     * @return minified JSON
     * @throws JsonProcessingException thrown if invalid JSON format
     * this method is used to minify the json
     * this function uses the jackson library to read the json and then minify it
     * mapper.writeValueAsString(jsonNode) is used to convert the jsonNode to a string
     * the string is then returned
     */
    @Override
    public String getJson() throws JsonProcessingException {

         String json =  super.getJson().toString();
            ObjectMapper mapper = new ObjectMapper();

            JsonNode jsonNode = mapper.readTree(json);
            System.out.println(mapper.writeValueAsString(jsonNode));

            String s = mapper.writeValueAsString(jsonNode);
            String s2 ="JsonMini: "+ s;



        return         s;
    }



}
