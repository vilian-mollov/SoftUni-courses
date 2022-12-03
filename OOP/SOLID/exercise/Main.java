package SOLID.exercise;

import SOLID.exercise.interfaces.Product;
import SOLID.exercise.products.Chips;
import SOLID.exercise.products.Chocolate;
import SOLID.exercise.products.Coke;
import SOLID.exercise.products.Lemonade;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Printer printer = new Printer();

        List<Product> products = new ArrayList<>();
        products.add(new Chocolate(100));
        products.add(new Coke(540));
        products.add(new Lemonade(1000));
        products.add(new Chips(72));

        CalorieCalculator calorieCalculator = new CalorieCalculator();

        printer.printSum(products, calorieCalculator);
        printer.printAverage(products, calorieCalculator);


        QuantityCalculator quantityCalculator = new QuantityCalculator();
        printer.printSum(products,quantityCalculator);
        printer.printAverage(products,quantityCalculator);

    }
}
