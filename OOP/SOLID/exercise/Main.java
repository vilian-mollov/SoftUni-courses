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

        CalorieCalculator calorieCalculator = new CalorieCalculator();
        Printer printer = new Printer();

        List<Product> products = new ArrayList<>();
        products.add(new Chocolate(24));
        products.add(new Coke(500));
        products.add(new Lemonade(700));
        products.add(new Chips(72));

        printer.printSum(products, calorieCalculator);
        printer.printAverage(products, calorieCalculator);

    }
}
