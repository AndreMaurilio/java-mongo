package app.service.serviceimpl;

import app.domain.dtos.CarDTO;
import app.domain.enums.Days;
import app.domain.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.repository.CarRepository;
import app.service.CarService;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public String noDriveDay(String placa) {


        Car car = carRepository.findByPlaca(placa)
                .orElseThrow(()-> new IllegalStateException("Placa não encontrada"));

        return car.carDrive().getCarNoDriveDay();
    }

    @Override
    public boolean carCanDriveToday(String plate) {

        return !noDriveDay(plate).equals(dayOfWeek());
    }

    public String dayOfWeek(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int s = c.get(Calendar.DAY_OF_WEEK);

        switch(s){

            case 1:
                return Days.SUNDAY.getCarNoDriveDay();
            case 2:
                return Days.TUESDAY.getCarNoDriveDay();
            case 3:
                return Days.WEDNSDAYS.getCarNoDriveDay();
            case 4:
                return Days.THURSDAY.getCarNoDriveDay();
            case 5:
                return Days.FRIDAY.getCarNoDriveDay();

        }
        return "Nao achado";

    }

    public Car insertNewCar(CarDTO carDTO){

        Car car = fromDTO(carDTO);
        return  carRepository.insert(car);

    }

    public Car fromDTO(CarDTO carDTO){
        return  new Car(
                carDTO.getPlaca(),
                carDTO.getModelo(),
                carDTO.getMarca(),
                carDTO.getCor(),
                carDTO.getAno(),
                carDTO.getValor());


    }


}
