package Inheritance.exercise.NeedForSpeed;

public class SportCar extends Car {

    private final static double DEFAULT_FUEL_CONSUMPTION = 10.0;

    public SportCar(double fuel, int horsePower) {
        super(fuel, horsePower);
        setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
