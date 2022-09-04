package DefiningClasses.N1CarInfo;

public class Car {
    private String brand;
    private String model;
    private int horsepower;

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model){
       this.model = model;
    }

    public int getHorsepower() {
        return horsepower;
    }
    public void setHorsepower(int horsepower){
        this.horsepower = horsepower;
    }

    public String carInfo(){
        return String.format("The car is: "+this.brand+" "+this.model+" - "+this.horsepower+" HP.");
    }


}
