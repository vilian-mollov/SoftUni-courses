package SOLID.exercise;

import SOLID.exercise.interfaces.Calculator;
import SOLID.exercise.interfaces.Drink;
import SOLID.exercise.interfaces.Food;
import SOLID.exercise.interfaces.Product;

import java.util.List;

public class QuantityCalculator implements Calculator {

    public double sum(List<Product> products){
        double sum = 0;

        for (Product product : products) {
            if(product instanceof Food){
                sum += ((Food)product).findKilograms();
            }
            if(product instanceof Drink){
                sum += ((Drink)product).findKilogramsOfDrinks();
            }
        }

        return sum;
    }

    public double average(List<Product> products){
        return sum(products) / products.size();
    }
}
