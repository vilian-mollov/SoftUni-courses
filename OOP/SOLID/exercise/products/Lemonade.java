package SOLID.exercise.products;

import SOLID.exercise.interfaces.Drink;
import SOLID.exercise.interfaces.Product;

public class Lemonade implements Product, Drink {

    public static final double CALORIES_PER_100_GRAMS = 53.0;
    public static final double DENSITY = 0.7;

    private double milliliters;

    public Lemonade(double milliliters) {
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }

    @Override
    public double findCalories() {
        return (CALORIES_PER_100_GRAMS / 100) * (milliliters * DENSITY);
    }

    @Override
    public double findKilogramsOfDrinks() {
        return (milliliters * DENSITY) / 1000;
    }
}
