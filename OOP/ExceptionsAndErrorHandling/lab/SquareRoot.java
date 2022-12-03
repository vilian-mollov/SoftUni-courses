package ExceptionsAndErrorHandling.lab;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            double n = Double.parseDouble(scanner.nextLine());

            if (n < 0) {
                throw new NumberFormatException();
            }

            double squareRoot = Math.sqrt(n);
            System.out.printf("%.2f%n", squareRoot);

        } catch (NumberFormatException e) {
            System.out.println("Invalid");

        } finally {
            System.out.println("Goodbye");
        }


    }
}
