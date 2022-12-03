package SOLID.exercise.products;

import SOLID.exercise.interfaces.Product;

public class Chocolate implements Product {

    public static final double CALORIES_PER_100_GRAMS = 575.0;

    private double grams;

    public Chocolate(double grams) {
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
