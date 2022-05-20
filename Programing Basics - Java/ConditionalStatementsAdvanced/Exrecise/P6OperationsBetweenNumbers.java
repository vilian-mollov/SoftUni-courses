package ConditionalStatementsAdvanced.Exrecise;

import java.util.Scanner;

public class P6OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        char symbol = scanner.next().charAt(0);
        double solution = 0.0;
        if(n2 == 0){
            System.out.printf("Cannot divide %d by zero", n1 );

        }else {

            if (symbol == '+') {
                solution = n1 + n2;
                System.out.printf("%d %c %d = %.0f - ", n1, symbol, n2, solution);
                if (solution % 2 == 0) {
                    System.out.println("even");
                } else {
                    System.out.println("odd");
                }

            } else if (symbol == '-') {
                solution = n1 - n2;
                System.out.printf("%d %c %d = %.0f - ", n1, symbol, n2, solution);
                if (solution % 2 == 0) {
                    System.out.println("even");
                } else {
                    System.out.println("odd");
                }

            } else if (symbol == '*') {
                solution = n1 * n2;
                System.out.printf("%d %c %d = %.0f - ", n1, symbol, n2, solution);
                if (solution % 2 == 0) {
                    System.out.println("even");
                } else {
                    System.out.println("odd");
                }

            } else if (symbol == '/') {
                double n3 = n2;
                solution = n1 / n3;
                System.out.printf("%d %c %d = %.2f", n1, symbol, n2, solution);


            } else if (symbol == '%') {
                solution = n1 % n2;
                System.out.printf("%d %c %d = %.0f", n1, symbol, n2, solution);

            }

        }
    }
}
