package Inheritance.exercise.Restaurant;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {


        Salmon salmon = new Salmon("SharkSalmon", new BigDecimal("27.95"), 1);

        System.out.println("Salmon grams: " + salmon.getGrams()); // Salmon should be at least 22 grams
        System.out.print(System.lineSeparator());

        Coffee coffee = new Coffee("Java", new BigDecimal("2.5"), 78.52);

        System.out.println("Coffee Price: " + coffee.getPrice());  // coffee price has to be at least 3.50
        System.out.println("Coffee Milliliters: " + coffee.getMilliliters()); // milliliters has to be at lest 50.00
        System.out.print(System.lineSeparator());

        Cake cake = new Cake("Chestnut Cake", new BigDecimal("2"), 50, 720);

        System.out.println("Cake price: " + cake.getPrice());       // at least 5
        System.out.println("Cake grams: " + cake.getGrams());       // at least 250
        System.out.println("Cake calories: " + cake.getCalories()); // at least 1000

    }
}
