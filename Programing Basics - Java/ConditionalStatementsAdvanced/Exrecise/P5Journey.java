package ConditionalStatementsAdvanced.Exrecise;

import java.util.Scanner;

public class P5Journey {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String rest = "Hotel";



        if (budget <= 100) {
            if (season.equals("summer")) {
                budget *= 0.30;
                rest = "Camp";
            } else if (season.equals("winter")) {
                budget *= 0.70;

            }

            System.out.println("Somewhere in Bulgaria");
            System.out.printf("%s - %.2f",rest,budget);


        } else if (budget <= 1000) {
            if (season.equals("summer")) {
                budget *= 0.40;
                rest = "Camp";
            } else if (season.equals("winter")) {
                budget *= 0.80;
            }
            System.out.println("Somewhere in Balkans");
            System.out.printf("%s - %.2f",rest,budget);


        } else if (budget > 1000) {
            budget *= 0.9;
            System.out.println("Somewhere in Europe");
            System.out.printf("%s - %.2f",rest,budget);

        }



    }
}
