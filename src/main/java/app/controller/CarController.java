package app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import app.service.CarService;


@RestController
@RequestMapping(value = "/autos")
public class CarController {


    @Autowired
    private CarService carService;


    @GetMapping(value = "/hello")
    public String carCanDrive(){

        return "hello world";
    }


    @GetMapping(value = "/candrive")
    public ResponseEntity<String> carCanDrive(@RequestParam String plate){

        String day = carService.noDriveDay(plate);

        return ResponseEntity.ok().body(day);
    }
}
