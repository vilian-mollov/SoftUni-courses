package FirstStepsInCoding.bonusExercise;

import java.util.Scanner;

public class R5TrainingLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double w = Double.parseDouble(scanner.nextLine()) * 100;
        double h = Double.parseDouble(scanner.nextLine()) * 100;

        h -= 100;
        double placesH = Math.floor(h /= 70);
        double placesW =Math.floor( w/= 120);

        System.out.printf("%.0f", placesH * placesW - 3);



    }
}
