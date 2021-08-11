package app.domain.dtos;

import app.domain.model.Car;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {

    private String id;
    private String cpf;
    private String nome;
    private String email;
    private String dataNascimento;
    private List<Car> carros;


    public UserDTO(String cpf, String nome, String email, String dataNascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.carros = new ArrayList<>();
    }

    public UserDTO(){}
}

