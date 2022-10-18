package Inheritance.exercise.Restaurant;

import java.math.BigDecimal;

public class Salmon extends MainDish {

    final double SALMON_GRAMS = 22.00;

    public Salmon(String name, BigDecimal price, double grams) {
        super(name, price, grams);
    }

    @Override
    protected void setGrams(double grams) {
        super.setGrams(grams);
        if (grams < 22.00) {
            this.grams = SALMON_GRAMS;
        }
    }
}
