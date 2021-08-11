package app.config;


import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.simple.parser.ParseException;
import app.util.UtilJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class DatabaseChangeLog {

//    @Autowired
//    CarRepository carRepository;

    @ChangeSet(order="001",id = "mock de 1000 veiculos",author="Andre")
    public void seedDataBase(MongoDatabase db) throws IOException, ParseException {

        UtilJson utilJson = new UtilJson(System.getProperty("user.dir")+"/MOCK_DATA.json");
        List<Document>docs = new ArrayList<>();
        MongoCollection<Document> carros = db.getCollection("automoveis");//
        docs = utilJson.readJsonArray(utilJson.getPath());
        carros.insertMany(docs);

    }
}
