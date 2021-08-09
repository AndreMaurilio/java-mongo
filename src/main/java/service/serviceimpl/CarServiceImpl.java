package service.serviceimpl;

import domain.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CarRepository;
import service.CarService;

import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public String noDriveDay(String placa) {


        Optional<Car> carOpt = carRepository.findById(placa);
        Car car = carOpt.get();

        return car.carDrive().getCarNoDriveDay();
    }

    @Override
    public boolean carCanDriveToday(String plate,String day) {
        Optional<Car> carOpt = carRepository.findById(plate);
        Car carFind = carOpt.get();

        return carFind.carDrive().getCarNoDriveDay().equals(day);
    }
}
