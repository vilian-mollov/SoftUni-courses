package Inheritance.exercise.Restaurant;

import java.math.BigDecimal;

public class Food extends Product {

    double grams;

    public Food(String name, BigDecimal price, double grams) {
        super(name, price);
        setGrams(grams);
    }

    public void setGrams(double grams) {
        if (grams <= 0) {
            throw new IllegalArgumentException("Grams can't be zero or negative.");
        }
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }
}
