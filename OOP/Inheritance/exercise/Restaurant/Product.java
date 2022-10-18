package Inheritance.exercise.Restaurant;

import java.math.BigDecimal;

public class Product {

    protected String name;
    protected BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        setPrice(price);
    }

    protected void setPrice(BigDecimal price) {
        if (price == null) {
            throw new IllegalArgumentException("price can't be null.");
        } else if (price.compareTo(new BigDecimal("0")) <= 0) {
            throw new IllegalArgumentException("price can't be zero or negative.");
        }
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
