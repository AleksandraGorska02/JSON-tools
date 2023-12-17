package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * This class is a component for a decorator pattern
 */
public class JsonComponent {
    private final Object json;

    /**
     * Class constructor
     * @param json JSON object
     */
    public JsonComponent(Object json){
        this.json = json;
    }

    /**
     * This method returns JSON object
     * @return  JSON object
     * @throws JsonProcessingException thrown if invalid JSON format
     */
    public Object getJson() throws JsonProcessingException {
        return json;
    }
}
