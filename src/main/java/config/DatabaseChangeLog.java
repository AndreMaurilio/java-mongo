package config;


import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import domain.model.Car;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class DatabaseChangeLog {

//    @Autowired
//    CarRepository carRepository;

    @ChangeSet(order="001",id = "notasgeral",author="Andre")
    public void seedDataBase(MongoDatabase db){

        List<Document>docs = new ArrayList<>();
        MongoCollection<Document> carros = db.getCollection("automoveis");
        docs.add(new Document("placa","DBZ-111").append("modelo","Golf").append("marca","VolksWagen").append("cor","Preto").append("ano","2012").append("valor",45000.00));
        docs.add(new Document("placa","AFG-125").append("modelo","Corsa").append("marca","GM").append("cor","Azul").append("ano","1999").append("valor",9000.00));
        docs.add(new Document("placa","TTR-784").append("modelo","Tiguam").append("marca","VolksWagen").append("cor","Branco").append("ano","2016").append("valor",125000.00));
        docs.add(new Document("placa","KQY-887").append("modelo","Passat").append("marca","VolksWagen").append("cor","Verde").append("ano","2020").append("valor",98000.00));
        docs.add(new Document("placa","OLJ-336").append("modelo","EcoSport").append("marca","Ford").append("cor","Cinza").append("ano","2011").append("valor",36000.00));
        carros.insertMany(docs);

    }
}
