package ForLoop.lab;

import java.util.Scanner;

public class B2NumbersToN1 {
    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int one = number; one >= 1; one--)
        {
            System.out.println(one);

        }
    }

}
