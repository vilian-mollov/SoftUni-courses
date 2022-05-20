package FirstStepsInCoding.bonusExercise;

import java.util.Scanner;

public class R3CelsiusToFahrenheit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double celsius = Double.parseDouble(scanner.next());

        double toFahrenheit = celsius * 1.8 + 32.00;
        System.out.printf("%.2f",toFahrenheit);



    }


}
