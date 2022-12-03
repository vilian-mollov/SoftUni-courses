package SOLID.exercise.products;

import SOLID.exercise.interfaces.Product;

public class Chips implements Product {

    public static final double CALORIES_PER_100_GRAMS = 529.0;
    private final double grams;

    public Chips(double grams) {
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }

    @Override
    public double findCalories() {
        return (CALORIES_PER_100_GRAMS / 100) * grams;
    }
}
