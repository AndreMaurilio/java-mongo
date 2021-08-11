package app.controller;


import app.domain.dtos.UserDTO;
import app.domain.model.Car;
import app.domain.model.User;
import app.service.UserService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")

public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping(value = "/insert")
    public ResponseEntity<User> saveNewUser(@RequestBody UserDTO userDTO){
    User user = userService.insertNewUser(userDTO);
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/addcar")
    public ResponseEntity<Void> addCar(@RequestParam String cpf, @RequestParam String plate){

        userService.addCar(cpf,plate);
        return ResponseEntity.ok().build();
    }


    @GetMapping(value = "/getcars")
    public ResponseEntity<List<Car>>findCarsByCpf(@RequestParam String cpf){

        List<Car> cars = userService.getAllCars(cpf);

        return ResponseEntity.ok(cars);
    }
}
