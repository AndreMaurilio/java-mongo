package connector;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import enums.ValueClass;
import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import util.UtilJson;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MongoConnector {





    public static void main(String[] args) throws IOException, ParseException {

        UtilJson utilJson = new UtilJson("/home/andre/Documentos/workspace/java-mongo/MOCK_DATA.json");

        MongoCredential mongoCredential = MongoCredential.createCredential("admin", "admin", "root".toCharArray());
        MongoClientOptions options = MongoClientOptions.builder()
                .writeConcern(WriteConcern.JOURNALED).build();
        MongoClient client = new MongoClient(new ServerAddress("127.0.0.1", 27017), Arrays.asList(mongoCredential), options);

        MongoDatabase database = client.getDatabase("notasgeral");

        MongoCollection<Document> notasbaixa = database.getCollection("baixa");
        MongoCollection<Document> notasmedia = database.getCollection("media");
        MongoCollection<Document> notasaltas = database.getCollection("alta");

        HashMap<String,List<Document>> documents = utilJson.readJsonArray(utilJson.getPath());

        notasbaixa.insertMany(documents.get(ValueClass.LOW.toString()));
        notasmedia.insertMany(documents.get(ValueClass.MEDIUM.toString()));
        notasaltas.insertMany(documents.get(ValueClass.HIGH.toString()));

        client.close();
        System.out.println("\nFim da operacao:");
    }






}
