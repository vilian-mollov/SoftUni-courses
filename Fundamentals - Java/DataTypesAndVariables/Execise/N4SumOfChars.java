package DataTypesAndVariables.Execise;

import java.util.Scanner;

public class N4SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

int counter =0;
        for (int i = 1; i <= n; i++) {
            String s = scanner.nextLine();
            char letter= s.charAt(0);
            counter +=letter;
        }


        System.out.printf("The sum equals: %d",counter);
    }
}
