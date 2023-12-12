package pl.put.poznan.transformer.logic;

public class JsonComponent {
    private final Object json;
    public JsonComponent(Object json){
        this.json = json;
    }
    public Object getJson(){
        return json;
    }
}
