package Polymorphism.exercise.Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {

    public Car(Double fuelQuantity, Double littersPerKilometer, Season season) {
        MAXIMUM_FUEL_CAPACITY = 150.00;
        setSeason(season);
        setFuelQuantity(fuelQuantity);
        setLittersPerKilometer(littersPerKilometer);
    }

    public String drive(Double kilometers) {
        validate(kilometers);

        if (fuelQuantity >= kilometers * littersPerKilometer) {
            fuelQuantity -= kilometers * littersPerKilometer;
            kilometersDriven += kilometers;
            return "Car travelled " + df.format(kilometers) + " km";
        } else {
            return "Car needs refueling!";
        }
    }

    public String refuel(Double amount) {
        validate(amount);

        if (amount + fuelQuantity >= MAXIMUM_FUEL_CAPACITY) {
            Double amountFilled = MAXIMUM_FUEL_CAPACITY - fuelQuantity;
            fuelQuantity = MAXIMUM_FUEL_CAPACITY;
            return String.format("Car tank is full!\n" +
                    "Amount filled: " + df.format(amountFilled));
        } else {
            fuelQuantity += amount;
            return "Fuel added to car tank: " + df.format(amount);
        }
    }

    @Override
    public String toString() {
        return String.format("Car: " + df.format(fuelQuantity) + " liters in the tank\n" +
                df.format(kilometersDriven) + " kilometers driven!");
    }
}
