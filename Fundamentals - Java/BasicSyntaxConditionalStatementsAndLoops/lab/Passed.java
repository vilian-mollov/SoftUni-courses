package BasicSyntaxConditionalStatementsAndLoops.lab;

import java.util.Scanner;

public class Passed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double grade = scanner.nextDouble();

        if (grade >= 3) {
            System.out.println("Passed!");
        }


    }
}
