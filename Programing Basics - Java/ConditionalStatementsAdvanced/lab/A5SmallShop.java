package ConditionalStatementsAdvanced.lab;

import java.util.Scanner;

public class A5SmallShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        String city = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());


        if (product.equals("coffee")) {
            if (city.equals("Sofia")) {
                System.out.printf("%f", 0.50 * quantity);

            } else if (city.equals("Plovdiv")) {
                System.out.printf("%f", 0.40 * quantity);

            } else if (city.equals("Varna")) {
                System.out.printf("%f", 0.45 * quantity);
            }

        } else if (product.equals("water")) {

            if (city.equals("Sofia")) {
                System.out.printf("%f", 0.80 * quantity);

            } else if (city.equals("Plovdiv")) {
                System.out.printf("%f", 0.70 * quantity);

            } else if (city.equals("Varna")) {
                System.out.printf("%f", 0.70 * quantity);
            }


        } else if (product.equals("beer")) {

            if (city.equals("Sofia")) {
                System.out.printf("%f", 1.20 * quantity);

            } else if (city.equals("Plovdiv")) {
                System.out.printf("%f", 1.15 * quantity);

            } else if (city.equals("Varna")) {
                System.out.printf("%f", 1.10 * quantity);
            }


        } else if (product.equals("sweets")) {

            if (city.equals("Sofia")) {
                System.out.printf("%f", 1.45 * quantity);

            } else if (city.equals("Plovdiv")) {
                System.out.printf("%f", 1.30 * quantity);

            } else if (city.equals("Varna")) {
                System.out.printf("%f", 1.35 * quantity);
            }

        } else if (product.equals("peanuts")) {

            if (city.equals("Sofia")) {
                System.out.printf("%f", 1.60 * quantity);

            } else if (city.equals("Plovdiv")) {
                System.out.printf("%f", 1.50 * quantity);

            } else if (city.equals("Varna")) {
                System.out.printf("%f", 1.55 * quantity);
            }

        }


    }
}
