package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * This class is a concrete decorator for a decorator pattern
 */
public class JsonRemove extends JsonDecorator{

    /**
     * Class constructor
     * @param jsonComponent component object
     * @throws JsonProcessingException thrown if invalid JSON format
     */
    public JsonRemove(JsonComponent jsonComponent) throws JsonProcessingException {
        super(jsonComponent);
    }

    /**
     *
     * @param objectNode JSON object node
     * @param key1 key to remove
     *
     */
    public void removeKey(ObjectNode objectNode, String key1) {
        objectNode.remove(key1);
        objectNode.forEach(node -> {
            if (node.isObject()) {
                ObjectNode objectNode1 = (ObjectNode) node;
                objectNode1.remove(key1);
                removeKey(objectNode1, key1);
            }
        });
    };

    /**
     * This method removes key from JSON
     * @return JSON without key
     * parameter to remove is given in the first line of json in the format "remove": "key",
     *       e.g. { "remove": "title",
     *       "title": "value",
     *       "title2": "value2"
     *       }
     *       this will remove the title key for us and return a json
     *       {
     *       "title2": "value2"
     *       }
     *       this method uses the jackson library to read the json and then remove the key
     *       mapper.writeValueAsString(jsonNode) is used to convert the jsonNode to a string
     *       the string is then returned
     *
     */
    @Override
    public String getJson() throws JsonProcessingException {

        String json =  super.getJson().toString();
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonNode = mapper.readTree(json);

        ObjectNode objectNode = (ObjectNode) jsonNode;
        String key = String.valueOf(objectNode.get("remove"));

        key =key.replace("\"","");
        removeKey(objectNode,key);

        objectNode.remove("remove");



       return mapper.writeValueAsString(objectNode);
    }
}
