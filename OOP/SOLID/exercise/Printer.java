package SOLID.exercise;

import java.util.List;

public class Printer {


    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";


    public void printSum(List<Object> products, CalorieCalculator calorieCalculator) {
        System.out.printf((SUM) + "%n", calorieCalculator.sum(products));
    }

    public void printAverage(List<Object> products,CalorieCalculator calorieCalculator) {
        System.out.printf((AVERAGE) + "%n", calorieCalculator.average(products));
    }
}
