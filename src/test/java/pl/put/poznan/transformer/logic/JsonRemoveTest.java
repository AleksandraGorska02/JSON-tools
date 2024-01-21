package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class JsonRemoveTest {

    @Test
    void testJsonRemove() throws JsonProcessingException {
        JsonComponent json = mock(JsonComponent.class);
        when(json.getJson()).thenReturn("{\"name\":\"John\", \"age\":30,\"car\":null}");
        JsonRemove jsonRemove = new JsonRemove(json);
        assertEquals("{\"name\":\"John\",\"age\":30,\"car\":null}", jsonRemove.getJson());
    }

    @Test
    void testRemoveKey1() throws JsonProcessingException {
        JsonComponent json = mock(JsonComponent.class);

        JsonRemove jsonRemove = new JsonRemove(json);
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("name", "John");
        jsonRemove.removeKey(objectNode, "name");

        assertEquals("{}", objectNode.toString());
    }


    @Test
    void testRemoveKey2() throws JsonProcessingException {
        JsonComponent json = mock(JsonComponent.class);

        JsonRemove jsonRemove = new JsonRemove(json);
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("name", "John");
        objectNode.put("age", 30);
        objectNode.put("car", (String) null);
        jsonRemove.removeKey(objectNode, "name");
        jsonRemove.removeKey(objectNode, "age");

        assertEquals("{\"car\":null}", objectNode.toString());
    }

    @Test
    void testGetJson1() throws JsonProcessingException {
        // Definiowanie przykładowego JSONa wejściowego
        String inputJson = "{ \"remove\": \"title\", \"title\": \"value\", \"title2\": \"value2\" }";
        JsonNode inputJsonNode = new ObjectMapper().readTree(inputJson);
        JsonComponent json = mock(JsonComponent.class);

        // Symulowanie metody getJson() z JsonComponent
        when(json.getJson()).thenReturn(inputJsonNode);

        // Wywołanie testowanej metody
        JsonRemove jsonRemove = new JsonRemove(json);
        String result = jsonRemove.getJson();
        JsonNode resultNode = new ObjectMapper().readTree(result);

        // Sprawdzenie, czy klucz "remove" został usunięty
        assertEquals("value2", resultNode.get("title2").asText());
        assertEquals(null, resultNode.get("remove"));
        assertEquals(null, resultNode.get("title"));
    }

    @Test
    void testGetJson2() throws JsonProcessingException {
        // Definiowanie przykładowego JSONa wejściowego bez klucza "remove"
        String inputJson = "{ \"title\": \"value\", \"title2\": \"value2\" }";
        JsonNode inputJsonNode = new ObjectMapper().readTree(inputJson);
        JsonComponent json = mock(JsonComponent.class);

        // Symulowanie metody getJson() z JsonComponent
        when(json.getJson()).thenReturn(inputJsonNode);

        // Wywołanie testowanej metody
        JsonRemove jsonRemove = new JsonRemove(json);
        String result = jsonRemove.getJson();
        JsonNode resultNode = new ObjectMapper().readTree(result);

        // Sprawdzenie, czy nie było klucza "remove" do usunięcia
        assertEquals("value", resultNode.get("title").asText());
        assertEquals("value2", resultNode.get("title2").asText());
        assertEquals(null, resultNode.get("remove"));
    }
}