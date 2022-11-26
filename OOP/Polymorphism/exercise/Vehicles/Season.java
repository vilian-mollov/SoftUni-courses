package Polymorphism.exercise.Vehicles;

public enum Season {

    SPRING(0.0),
    SUMMER(0.9),
    AUTUMN(0.0),
    WINTER(0.0);

    final Double fuelConsumptionIncrease;

    Season(Double fuelConsumptionIncrease) {
        this.fuelConsumptionIncrease = fuelConsumptionIncrease;
    }


}
