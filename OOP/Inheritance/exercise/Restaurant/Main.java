package Inheritance.exercise.Restaurant;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {


        Salmon salmon = new Salmon("SharkSalmon", new BigDecimal("27.95"), 1);

        System.out.println("Salmon grams: " + salmon.getGrams()); // Salmon should be at least 22 grams

        Coffee coffee = new Coffee("Java", new BigDecimal("2.5"), 78.52);

        System.out.println("Coffee Milliliters: " + coffee.getMilliliters()); // milliliters has to be at lest 50.00
        System.out.println("Coffee Price: " + coffee.getPrice());  // coffee price has to be at least 3.50


    }
}
