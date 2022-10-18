package Inheritance.exercise.Restaurant;

import java.math.BigDecimal;

public class Dessert extends Food {

    double calories;

    public Dessert(String name, BigDecimal price, double grams, double calories) {
        super(name, price, grams);
        setCalories(calories);
    }

    private void setCalories(double calories) {
        if(calories <= 0){
            throw new IllegalArgumentException("Calories can't be zero or negative.");
        }
        this.calories = calories;
    }

    public double getCalories() {
        return calories;
    }
}
