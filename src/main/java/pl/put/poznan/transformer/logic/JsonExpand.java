package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * This class is a concrete decorator for a decorator pattern
 */
public class JsonExpand extends JsonDecorator{
    /**
     * Class constructor
     * @param jsonComponent component object
     * @throws JsonProcessingException thrown if invalid JSON format
     */
    public JsonExpand(JsonComponent jsonComponent) throws JsonProcessingException {
        super(jsonComponent);
    }

    /**
     * This method returns expanded JSON
     * @return expanded JSON
     * @throws JsonProcessingException thrown if invalid JSON format
     * this method is used to expand the json
     * this function uses the gson library to read the json and then expand it
     * gson.toJson(je) is used to convert the jsonElement to a string
     * the string is then returned
     *
     */
    @Override
    public String getJson() throws JsonProcessingException {
        String json =  super.getJson().toString();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(json);
        return gson.toJson(je);
    }
}
