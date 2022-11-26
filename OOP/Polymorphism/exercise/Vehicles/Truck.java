package Polymorphism.exercise.Vehicles;

public class Truck extends Vehicle {

    private static final double TRUCK_BONUS_EXPENSES = 0.5;
    public Truck(Double fuelQuantity, Double littersPerKilometer, Season season) {
        MAXIMUM_FUEL_CAPACITY = 250.00;
        setSeason(season);
        setFuelQuantity(fuelQuantity);
        this.littersPerKilometer = littersPerKilometer;
    }


    public String drive(Double kilometers) {
        validate(kilometers);

        if (fuelQuantity >= kilometers * littersPerKilometer) {
            fuelQuantity -= kilometers * littersPerKilometer;
            kilometersDriven += kilometers;
            return "Truck travelled " + df.format(kilometers) + " km";
        } else {
            return "Truck needs refueling!";
        }
    }


    public String refuel(Double amount) {
        validate(amount);

        if (amount + fuelQuantity >= MAXIMUM_FUEL_CAPACITY) {
            Double amountFilled = MAXIMUM_FUEL_CAPACITY - fuelQuantity;
            fuelQuantity = MAXIMUM_FUEL_CAPACITY;
            return String.format("Truck tank is full!\n" +
                    "Amount filled: " + df.format(amountFilled));
        } else {
            fuelQuantity += amount;
            return "Fuel added to truck tank: " + df.format(amount);
        }
    }

   @Override
    public void setLittersPerKilometer(Double littersPerKilometer) {
        validate(littersPerKilometer);

        this.littersPerKilometer = littersPerKilometer + season.fuelConsumptionIncrease + TRUCK_BONUS_EXPENSES;
    }

    @Override
    public String toString() {
        return String.format("Truck: " + df.format(fuelQuantity) + " liters in the tank\n" +
                df.format(kilometersDriven) + " kilometers driven!");
    }
}
