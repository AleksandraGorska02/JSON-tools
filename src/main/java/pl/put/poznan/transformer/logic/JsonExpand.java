package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonExpand extends JsonDecorator{
    public JsonExpand(JsonComponent jsonComponent) throws JsonProcessingException {
        super(jsonComponent);
    }

    /**
     * Metoda zwracająca rozwinięty JSON

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
