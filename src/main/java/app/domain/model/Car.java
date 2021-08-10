package app.domain.model;


import app.domain.enums.Days;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Data
@Document(collection = "automoveis")
public class Car {

    @Id
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;
    private String placa;
    private String modelo;
    private String marca;
    private String cor;
    private String ano;
    private Double valor;


    public Car(String placa,String modelo, String marca, String cor, String ano, Double valor) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.ano = ano;
        this.valor = valor;



    }

    public Car(String id, String placa, String modelo, String marca, String cor, String ano, Double valor) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.ano = ano;
        this.valor = valor;
    }

    public Car(){};





    public Days carDrive(){
        String p  = getPlaca();
        p = p.substring(p.length()-1);
        if(Days.SUNDAY.getFinalPlate().contains(p)) return Days.SUNDAY;
        else if(Days.TUESDAY.getFinalPlate().contains(p)) return Days.TUESDAY;
        else if(Days.WEDNSDAYS.getFinalPlate().contains(p)) return Days.WEDNSDAYS;
        else if(Days.THURSDAY.getFinalPlate().contains(p)) return Days.THURSDAY;
        else if(Days.FRIDAY.getFinalPlate().contains(p)) return Days.FRIDAY;

        return Days.NONE;
    }
}
