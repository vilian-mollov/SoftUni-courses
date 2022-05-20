package NestedLoop.lab;

import java.util.Scanner;

public class N5Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String destination = scanner.nextLine();

        double wholeSum = 0;

        while (!destination.equals("End")) {

            double minimumBudget = Double.parseDouble(scanner.nextLine());
            double sums = Double.parseDouble(scanner.nextLine());
            for (double i = sums; i < minimumBudget; i += sums) {

                sums = Double.parseDouble(scanner.nextLine());

            }

            System.out.printf("Going to %s!%n", destination);

            destination = scanner.nextLine();
        }


    }

}
