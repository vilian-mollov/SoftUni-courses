package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class N7VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String insert = scanner.nextLine();
        double insertedCoins = 0.0;
        while (!insert.equals("Start")) {
            double intoDouble = Double.parseDouble(insert);
            if (intoDouble == 1 || intoDouble == 2 || intoDouble == 0.5 || intoDouble == 0.2 || intoDouble == 0.1) {
                insertedCoins += intoDouble;
                insert = scanner.nextLine();
            } else {
                System.out.printf("Cannot accept %.2f%n", intoDouble);
                insert = scanner.nextLine();
            }
        }
        insert = scanner.nextLine();

        while (!insert.equals("End")) {
            switch (insert) {
                case "Nuts":
                    if (insertedCoins >= 2.0) {
                        insertedCoins -= 2.0;
                        System.out.println("Purchased Nuts");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }

                    break;
                case "Water":
                    if (insertedCoins >= 0.7) {
                        insertedCoins -= 0.7;
                        System.out.println("Purchased Water");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if (insertedCoins >= 1.5) {
                        insertedCoins -= 1.5;
                        System.out.println("Purchased Crisps");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    if (insertedCoins >= 0.8) {
                        insertedCoins -= 0.8;
                        System.out.println("Purchased Soda");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    if (insertedCoins >= 1.0) {
                        insertedCoins -= 1.0;
                        System.out.println("Purchased Coke");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }

            insert = scanner.nextLine();
        }
        System.out.printf("Change: %.2f%n", insertedCoins);

    }
}
