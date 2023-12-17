package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * This class is a decorator for a decorator pattern
 */
public class JsonDecorator extends JsonComponent{
    private final JsonComponent jsonComponent;

    /**
     * Class constructor
     * @param jsonComponent component object
     * @throws JsonProcessingException thrown if invalid JSON format
     */
    public JsonDecorator(JsonComponent jsonComponent) throws JsonProcessingException {
        super(jsonComponent.getJson());
        this.jsonComponent = jsonComponent;
    }

    /**
     *
     * @return JSON object
     * @throws JsonProcessingException thrown if invalid JSON format
     */
    @Override
    public Object getJson() throws JsonProcessingException {
        return jsonComponent.getJson();
    }
}
