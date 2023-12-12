package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



public class JsonRemove extends JsonDecorator{


    public JsonRemove(JsonComponent jsonComponent) throws JsonProcessingException {
        super(jsonComponent);

    }


  


    @Override
    public String getJson() throws JsonProcessingException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Object json = super.getJson();
            String jstring = mapper.writeValueAsString(json);
            JsonNode jsonNode = mapper.readTree(jstring);
            System.out.println(mapper.writeValueAsString(jsonNode));
            String jsonMin = mapper.writeValueAsString(jsonNode);
            return jsonMin;}
        catch (Exception e){
            return "error";
        }
    }



}
