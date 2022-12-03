package SOLID.exercise.interfaces;

import java.util.List;

public interface Calculator {

    double sum(List<Product> products);
    double average(List<Product> products);
}
