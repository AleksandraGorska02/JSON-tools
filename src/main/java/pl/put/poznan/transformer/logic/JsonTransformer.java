package pl.put.poznan.transformer.logic;

public class JsonTransformer {
    private final Object json;

    public JsonTransformer(Object json) {
        this.json = json;
    }
    public Object transform(){
        JsonComponent jsonComponent = new JsonComponent(json);
        return jsonComponent.getJson();
    }


}
