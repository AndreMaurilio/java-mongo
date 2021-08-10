package app.domain.enums;

public enum Days {

    SUNDAY("0-1","Segunda-Feira"),
    TUESDAY("2-3","Terca-Feira"),
    WEDNSDAYS("4-5","Quarta-Feira"),
    THURSDAY("6-7","Quinta-Feira"),
    FRIDAY("8-9","Sexta-Feira"),
    NONE("","ERROR");


    private String finalPlate;
    private String carNoDriveDay;

    Days(String plate,String day){
        this.finalPlate = plate;
        this.carNoDriveDay = day;
    }

    public String getFinalPlate() {
        return finalPlate;
    }

    public void setFinalPlate(String finalPlate) {
        this.finalPlate = finalPlate;
    }

    public String getCarNoDriveDay() {
        return carNoDriveDay;
    }

    public void setCarNoDriveDay(String carNoDriveDay) {
        this.carNoDriveDay = carNoDriveDay;
    }
}
