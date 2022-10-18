package Inheritance.exercise.Restaurant;

import java.math.BigDecimal;

public class Beverage extends Product {

    double milliliters;

    public Beverage(String name, BigDecimal price, double milliliters) {
        super(name, price);
        setMilliliters(milliliters); // todo make validation with setter for milliliters to not be <= 0;
    }

    private void setMilliliters(double milliliters) {
        if (milliliters <= 0) {
            throw new IllegalArgumentException("Milliliters can't be zero or negative.");
        }
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }
}
