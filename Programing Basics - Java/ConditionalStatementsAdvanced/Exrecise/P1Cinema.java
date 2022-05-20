package ConditionalStatementsAdvanced.Exrecise;

import java.util.Scanner;

public class P1Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfProjection = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        double income = 0.00;

        if (typeOfProjection.equals("Premiere")) {

            income = rows * columns * 12.00;


        } else if (typeOfProjection.equals("Normal")) {
            income = rows * columns * 7.50;

        } else if (typeOfProjection.equals("Discount")) {
            income = rows * columns * 5.00;

        }
        System.out.printf("%.2f Leva", income);


    }
}
