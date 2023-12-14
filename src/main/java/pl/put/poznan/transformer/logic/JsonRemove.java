package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonRemove extends JsonDecorator{
    public JsonRemove(JsonComponent jsonComponent) throws JsonProcessingException {
        super(jsonComponent);
    }

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
     * Method that removes key from json
     * @return json without key
     *parametr do usunęcia podajemy w pierwszej lini jsona w formacie "remove":"key",
     * np. {"remove":"title",
     * "title":"value",
     * "title2":"value2"
     * }
     * usunie nam to klucz title i zwróci jsona
     * {
     * "title2":"value2"
     * }
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
