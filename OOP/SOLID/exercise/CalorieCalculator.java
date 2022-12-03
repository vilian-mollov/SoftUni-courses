package SOLID.exercise;

import SOLID.exercise.interfaces.Calculator;
import SOLID.exercise.interfaces.Product;
import SOLID.exercise.products.Chips;
import SOLID.exercise.products.Chocolate;
import SOLID.exercise.products.Coke;
import SOLID.exercise.products.Lemonade;

import java.util.List;

public class CalorieCalculator implements Calculator {
    public double sum(List<Product> products) {
        double sum = 0;

        for (Product product : products) {
            if (product instanceof Coke) {
                double grams = ((Coke) product).getMilliliters() * Coke.DENSITY;
                sum += product.findCalories();
            }

            if (product instanceof Lemonade) {
                double grams = ((Lemonade) product).getMilliliters() * Lemonade.DENSITY;
                sum += product.findCalories();
            }

            if (product instanceof Chocolate) {
                sum += product.findCalories();
            }

            if(product instanceof Chips){
                sum += product.findCalories();
            }

        }

        return sum;
    }

    public double average(List<Product> products) {
        return sum(products) / products.size();
    }


}
