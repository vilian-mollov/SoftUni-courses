package preliminaryExam;

import java.util.Scanner;

public class N3finalconcurs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int numberOfDancers = Integer.parseInt(scanner.nextLine());
        double points = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String place = scanner.nextLine();
        double price = 0;

        if (place.equals("Bulgaria")) {
            price = points * numberOfDancers;
            if (season.equals("summer")) {
                price *= 0.95;
            } else {
                price *= 0.92;
            }

        } else {
            price = points * numberOfDancers;
            price = price + price * 0.5;

            if (season.equals("summer")) {
                price *= 0.90;
            } else {
                price *= 0.85;
            }

        }
        double charity = price * 0.75;
            price *= 0.25;

        System.out.printf("Charity - %.2f%n",charity);
        System.out.printf("Money per dancer - %.2f", price / numberOfDancers);

    }
}
