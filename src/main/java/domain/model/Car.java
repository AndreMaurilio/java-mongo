package domain.model;


import domain.enums.Days;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document("carros")
public class Car {

    @Id
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }



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
