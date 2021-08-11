package app.domain.dtos;

import lombok.Data;

@Data
public class CarDTO {

    private String id;
    private String placa;
    private String modelo;
    private String marca;
    private String cor;
    private String ano;
    private Double valor;
}
