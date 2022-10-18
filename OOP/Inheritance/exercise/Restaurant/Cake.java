package Inheritance.exercise.Restaurant;

import java.math.BigDecimal;

public class Cake extends Dessert{

    double CAKE_GRAMS = 250.00;
    double CAKE_CALORIES = 1000.00;
    BigDecimal CAKE_PRICE = new BigDecimal("5");

    public Cake(String name, BigDecimal price, double grams, double calories) {
        super(name, price, grams, calories);
    }
}
