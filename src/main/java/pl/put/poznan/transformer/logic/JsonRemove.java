package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.simple.JSONObject;



public class JsonRemove extends JsonDecorator{


    public JsonRemove(JsonComponent jsonComponent) throws JsonProcessingException {
        super(jsonComponent);

    }





    @Override
    public String getJson() throws JsonProcessingException {

         String json =  super.getJson();
            ObjectMapper mapper = new ObjectMapper();

            JsonNode jsonNode = mapper.readTree(json);
            System.out.println(mapper.writeValueAsString(jsonNode));

            String s = mapper.writeValueAsString(jsonNode);
            String s2 ="JsonRemove: "+ s;


                     //usuniecie spacji
            s2 = s2.replaceAll("\\s+","");

        return         s2;
    }



}
