package app.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document("usuarios")
public class User {


    @Id
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;
    private String cpf;
    private String nome;
    private String email;
    private String dataNascimento;
    @DBRef
    private List<Car> carros;

    public User(String cpf, String email, String nome, String dataNascimento, List<Car> carros) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.carros = carros;
    }

    public User(){}

    public void addCar(Car carro){
        if(this.getCarros() == null){
            this.setCarros(new ArrayList<>());
        }
        this.getCarros().add(carro);

    }

}
