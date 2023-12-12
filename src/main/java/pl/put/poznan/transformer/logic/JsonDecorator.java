package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonDecorator extends JsonComponent{
    private final JsonComponent jsonComponent;

    public JsonDecorator(JsonComponent jsonComponent) throws JsonProcessingException {
        super(jsonComponent.getJson());
        this.jsonComponent = jsonComponent;
    }

    @Override
    public String getJson() throws JsonProcessingException {
        return jsonComponent.getJson();
    }
}
