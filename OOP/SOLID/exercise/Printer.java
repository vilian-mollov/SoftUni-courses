package SOLID.exercise;

import SOLID.exercise.interfaces.Product;

import java.util.List;

public class Printer {


    private static final String SUM = "Sum: %.2f";
    private static final String AVERAGE = "Average: %.2f";


    public void printSum(List<Product> products, CalorieCalculator calorieCalculator) {
        System.out.printf((SUM) + "%n", calorieCalculator.sum(products));
    }

    public void printAverage(List<Product> products,CalorieCalculator calorieCalculator) {
        System.out.printf((AVERAGE) + "%n", calorieCalculator.average(products));
    }
}
