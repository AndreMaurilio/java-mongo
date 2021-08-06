package util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bson.Document;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.bson.json.JsonReader;
import org.bson.json.JsonWriter;
import com.google.gson.Gson;
import org.json.simple.JSONArray;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.parser.ParseException;
public class UtilJson {


    String path;

    String [] array;
    JsonReader jsonReader;

    public UtilJson(String path){
        this.path = path;

    }






    public HashMap<String,List<Document>>readJsonArray(String path) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(path));
        HashMap<String,List<Document>> collections = new HashMap<>();
        collections.put("baixa",new ArrayList<Document>() );
        collections.put("media",new ArrayList<Document>() );
        collections.put("alta",new ArrayList<Document>() );


        for(Object json : jsonArray){
            Document d = new Document();
            JSONObject j = (JSONObject) json;

            Document doc = new Document("cartao",j.get("cartao").toString())
                                .append("codigo_de_barra", j.get("codigo_de_barra").toString())
                                .append("valor", j.get("valor"))
                                .append("data_fechamento", j.get("data_fechamento").toString())
                                .append("data_vencimento", j.get("data_vencimento").toString());
            if((Double) doc.get("valor")<1000){
                collections.get("baixa").add(doc);
            }else if((Double) doc.get("valor")>1000 && ((Double) doc.get("valor")<5000)){
                collections.get("media").add(doc);
            }else if((Double) doc.get("valor")>5000){
                collections.get("alta").add(doc);
            }


        }
        return collections;
    }




    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
