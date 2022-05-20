package BasicSyntaxConditionalStatementsAndLoops.lab;

import java.util.Scanner;

public class MultiplicationTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        for (int i = 1; i <= 10 ; i++) {
            int product = number * i;
            System.out.printf("%d X %d = %d%n",number,i,product );
        }


    }
}
