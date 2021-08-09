package domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document("usuarios")
public class User {


    @Id
    private String cpf;
    private String nome;
    private String email;
    private String dataNascimento;
    private List<Car> carros;

    public User(String cpf, String email, String nome, String dataNascimento, List<Car> carros) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.carros = carros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Car> getCarros() {
        return carros;
    }

    public void setCarros(List<Car> carros) {
        this.carros = carros;
    }
}
