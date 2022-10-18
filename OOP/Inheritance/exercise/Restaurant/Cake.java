package Inheritance.exercise.Restaurant;

import java.math.BigDecimal;

public class Cake extends Dessert {

    private final static double CAKE_GRAMS = 250.00;
    private final static double CAKE_CALORIES = 1000.00;
    private final static BigDecimal CAKE_PRICE = new BigDecimal("5");

    public Cake(String name, BigDecimal price, double grams, double calories) {
        super(name, price, grams, calories);
    }

    @Override
    protected void setGrams(double grams) {
        super.setGrams(grams);
        if (this.grams < CAKE_GRAMS) {
            this.grams = CAKE_GRAMS;
        }
    }

    @Override
    protected void setPrice(BigDecimal price) {
        super.setPrice(price);
        if (this.price.compareTo(CAKE_PRICE) < 0) {
            this.price = CAKE_PRICE;
        }
    }

    @Override
    protected void setCalories(double calories) {
        super.setCalories(calories);
        if (this.calories < CAKE_CALORIES) {
            this.calories = CAKE_CALORIES;
        }
    }
}
