package Inheritance.exercise.Restaurant;

import java.math.BigDecimal;

public class Coffee extends HotBeverage {

    private final static double COFFEE_MILLILITERS = 50.00;
    private final static BigDecimal COFFEE_PRICE = new BigDecimal("3.50");
    private double caffeine;

    public Coffee(String name, BigDecimal price, double milliliters) {
        super(name, price, milliliters);
    }

    @Override
    protected void setMilliliters(double milliliters) {
        super.setMilliliters(milliliters);
        if (milliliters < 50.00) {
            this.milliliters = COFFEE_MILLILITERS;
        }
    }

    @Override
    protected void setPrice(BigDecimal price) {
        super.setPrice(price);
        if (this.price.compareTo(COFFEE_PRICE) < 0) {
            this.price = COFFEE_PRICE;
        }
    }

    public void setCaffeine(double caffeine) {
        this.caffeine = caffeine;
    }

    public double getCaffeine() {
        return caffeine;
    }
}
