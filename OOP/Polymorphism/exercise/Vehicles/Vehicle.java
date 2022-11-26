package Polymorphism.exercise.Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    protected  Double MAXIMUM_FUEL_CAPACITY;

    protected Double fuelQuantity = 0.0;
    protected Double littersPerKilometer;

    protected Double kilometersDriven = 0.0;
    protected Season season;

    protected DecimalFormat df = new DecimalFormat("#0.00");


    public abstract String drive(Double kilometers);

    public abstract String refuel(Double amount);

    public void setFuelQuantity(Double fuelQuantity) {
        validate(fuelQuantity);

        if (this.fuelQuantity + fuelQuantity > MAXIMUM_FUEL_CAPACITY) {
            this.fuelQuantity = MAXIMUM_FUEL_CAPACITY;
            return;
        }

        this.fuelQuantity += fuelQuantity;
    }

    public void setLittersPerKilometer(Double littersPerKilometer) {
        validate(littersPerKilometer);

        this.littersPerKilometer = littersPerKilometer + season.fuelConsumptionIncrease;
    }

    public boolean validate(Double number){
        if (number < 0) {
            throw new IllegalArgumentException("You can't add negative number!");
        }
        return true;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

}
