package app.util;

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


    public UtilJson(String path){
        this.path = path;

    }




    public List<Document>readJsonArray(String path) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(path));
//        HashMap<String,List<Document>> collections = new HashMap<>();
//        collections.put("baixa",new ArrayList<Document>() );
//        collections.put("media",new ArrayList<Document>() );
//        collections.put("alta",new ArrayList<Document>() );
        List<Document> collections = new ArrayList<>();


        for(Object json : jsonArray){
            Document d = new Document();
            JSONObject j = (JSONObject) json;

            Document doc = new Document("placa",j.get("placa").toString())
                                .append("modelo", j.get("modelo").toString())
                                .append("marca", j.get("marca").toString())
                                .append("cor", j.get("cor").toString())
                                .append("ano", j.get("ano").toString())
                                .append("valor", j.get("valor"));

            collections.add(doc);

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
