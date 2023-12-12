package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonComponent {
    private final String json;
    public JsonComponent(String json){
        this.json = json;
    }
    public String getJson() throws JsonProcessingException {
        return json;
    }
}
