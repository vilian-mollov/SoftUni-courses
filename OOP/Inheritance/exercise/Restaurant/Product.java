package Inheritance.exercise.Restaurant;

import java.math.BigDecimal;

public class Product {

    String name;
    BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        setPrice(price);
    }

    private void setPrice(BigDecimal price) {
        if(price == null){
            throw new IllegalArgumentException("price cant be null.");
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
