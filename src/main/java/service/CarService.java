package service;

import domain.model.Car;

public interface CarService {

    public String noDriveDay(String placa);

    public boolean carCanDriveToday( String plate,String day);
}
