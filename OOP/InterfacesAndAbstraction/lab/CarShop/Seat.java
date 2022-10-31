package InterfacesAndAbstraction.lab.CarShop;

public class Seat extends CarImpl implements Sellable {
    private  Double price;

    public Seat(String model, String color, int horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public String getModel() {
        return this.model;
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

    @Override
    public String toString() {
        return String.format("This is %s produced in %s. The price is %.2f€\n",this.model,countryProduced,price);
    }

    @Override
    public Double getPrice() {
        return null;
    }
}
