package DataTypesAndVariables.Execise;

import java.util.Scanner;

public class N1IntegerOperations {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
        int numberOne = Integer.parseInt(scanner.nextLine());
        int numberTwo = Integer.parseInt(scanner.nextLine());
        int numberThree = Integer.parseInt(scanner.nextLine());
        int numberFour = Integer.parseInt(scanner.nextLine());

        System.out.printf("%d",((numberOne+numberTwo)/numberThree)*numberFour);
    }
}
