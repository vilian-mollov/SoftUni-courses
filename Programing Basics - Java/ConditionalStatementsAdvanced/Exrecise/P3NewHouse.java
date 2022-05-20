package ConditionalStatementsAdvanced.Exrecise;

import java.util.Scanner;

public class P3NewHouse {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String flowers = scanner.nextLine();
        int number = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double roses = 5.0;
        double dahlias = 3.8;
        double tulips = 2.80;
        double narcissus = 3.0;
        double gladiolus = 2.5;
        double total = 0.0;


        switch (flowers) {
            case "Roses":
                total = roses * number;
                if (number > 80) {
                    total *= 0.90;
                }
            break;
            case "Dahlias":
                total = dahlias * number;
                if (number > 90) {
                    total *= 0.85;
                }
            break;
            case "Tulips":
                total = tulips * number;
                if (number > 80) {
                    total *= 0.85;
                }
            break;
            case "Narcissus":
                total = narcissus * number;
                if (number < 120) {
                    total = total + total * 0.15;
                }
            break;
            case "Gladiolus":
                total = gladiolus * number;
                if (number < 80) {
                    total = total + total * 0.20;
                }
            break;
        }

        if (budget >= total) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",number,flowers, budget - total);

        }else{
            System.out.printf("Not enough money, you need %.2f leva more.", total - budget);


        }


    }
}
