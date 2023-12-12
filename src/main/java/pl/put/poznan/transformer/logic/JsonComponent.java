package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonComponent {
    private final Object json;
    public JsonComponent(Object json){
        this.json = json;
    }
    public Object getJson() throws JsonProcessingException {
        return json;
    }
}
