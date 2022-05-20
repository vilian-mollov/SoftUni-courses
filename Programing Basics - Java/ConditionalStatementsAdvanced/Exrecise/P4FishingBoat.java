package ConditionalStatementsAdvanced.Exrecise;

import java.util.Scanner;

public class P4FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        double price = 0.00;

        switch (season) {
            case "Spring":
                price = 3000.0;
                if (numberOfPeople % 2 == 0) {
                    price = price - price * 0.05;
                }
                if (numberOfPeople <= 6) {
                    price = price - price * 0.1;

                } else if (numberOfPeople <= 11 && numberOfPeople >= 7) {
                    price = price - price * 0.15;

                } else if (numberOfPeople >= 12) {
                    price = price - price * 0.25;
                }
                break;
            case "Summer":
                price = 4200.0;
                if (numberOfPeople % 2 == 0) {
                    price = price - price * 0.05;
                }
                if (numberOfPeople <= 6) {
                    price = price - price * 0.1;

                } else if (numberOfPeople <= 11 && numberOfPeople >= 7) {
                    price = price - price * 0.15;

                } else if (numberOfPeople >= 12) {
                    price = price - price * 0.25;

                }
                break;

            case "Autumn":
                price = 4200.0;
                if (numberOfPeople <= 6) {
                    price = price - price * 0.1;

                } else if (numberOfPeople <= 11 && numberOfPeople >= 7) {
                    price = price - price * 0.15;

                } else if (numberOfPeople >= 12) {
                    price = price - price * 0.25;

                }
            break;
            case "Winter":
                price = 2600;
                if (numberOfPeople % 2 == 0) {
                    price = price - price * 0.05;
                }
                if (numberOfPeople <= 6) {
                    price = price - price * 0.1;

                } else if (numberOfPeople <= 11 && numberOfPeople >= 7) {
                    price = price - price * 0.15;

                } else if (numberOfPeople >= 12) {
                    price = price - price * 0.25;

                }
            break;
        }

        if (budget >= price) {
            System.out.printf("Yes! You have %.2f leva left.", budget - price);

        } else {
            System.out.printf("Not enough money! You need %.2f leva.", price - budget);
        }


    }
}
