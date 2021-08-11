package app.service.serviceimpl;

import app.domain.dtos.UserDTO;
import app.domain.model.Car;
import app.domain.model.User;
import app.repository.CarRepository;
import app.repository.UserRepository;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void addCar(String cpf, String plate) {

        Car car = carRepository.findByPlaca(plate)
                .orElseThrow(()-> new IllegalStateException("Placa não encontrada"));

        User user = userRepository.findByCpf(cpf)
                .orElseThrow(()-> new IllegalStateException("Usuario não encontrado"));

        user.addCar(car);
        userRepository.save(user);


    }

    public User insertNewUser(UserDTO userDTO){
        User user = fromUserDTO(userDTO);

        return  userRepository.insert(user);
    }


    public User fromUserDTO(UserDTO userDTO){
        return  new User(
        userDTO.getCpf(),
        userDTO.getNome(),
        userDTO.getEmail(),
        userDTO.getDataNascimento(),
        userDTO.getCarros());

    }

    public List<Car> getAllCars(String cpf){


        User user = userRepository.findByCpf(cpf)
                .orElseThrow(()-> new IllegalStateException("Usuario não encontrado"));

        return  user.getCarros();

    }
}
