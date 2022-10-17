package Inheritance.exercise.NeedForSpeed;

public class Vehicle {

    private final static double DEFAULT_FUEL_CONSUMPTION = 1.25;
    protected double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    //drive a car if you have enough fuel
    public void drive(double kilometers) {

        if (kilometers <= 0) {
            throw new IllegalArgumentException("Kilometers cannot be 0 or less");
        }

        double neededFuel = kilometers * this.fuelConsumption;
        if (this.fuel >= neededFuel) {
            this.fuel -= neededFuel;
        }
    }


}
