package app.service;

import app.domain.dtos.UserDTO;
import app.domain.model.Car;
import app.domain.model.User;

import java.util.List;

public interface UserService {
    void addCar(String cpf, String plate);

    User insertNewUser(UserDTO userDTO);

    List<Car> getAllCars(String cpf);
}
