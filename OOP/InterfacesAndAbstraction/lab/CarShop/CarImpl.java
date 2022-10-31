package InterfacesAndAbstraction.lab.CarShop;

public class CarImpl implements Car {

    protected   String model;
    protected  String color;
    protected  int horsepower;
    protected  String countryProduced;

    public CarImpl(String model, String color, int horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsepower = horsePower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Integer getHorsePower() {
        return horsepower;
    }

    @Override
    public String countryProduced() {
        return countryProduced;
    }
}
