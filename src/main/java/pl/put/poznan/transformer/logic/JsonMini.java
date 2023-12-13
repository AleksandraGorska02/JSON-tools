package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonMini extends JsonDecorator{


    public JsonMini(JsonComponent jsonComponent) throws JsonProcessingException {
        super(jsonComponent);

    }





    @Override
    public String getJson() throws JsonProcessingException {

         String json =  super.getJson().toString();
            ObjectMapper mapper = new ObjectMapper();

            JsonNode jsonNode = mapper.readTree(json);
            System.out.println(mapper.writeValueAsString(jsonNode));

            String s = mapper.writeValueAsString(jsonNode);
            String s2 ="JsonMini: "+ s;


                     //usuniecie spacji
          //  s2 = s2.replaceAll("\\s+","");

        return         s;
    }



}
