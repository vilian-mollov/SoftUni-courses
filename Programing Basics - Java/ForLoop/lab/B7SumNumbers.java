package ForLoop.lab;

import java.util.Scanner;

public class B7SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers = Integer.parseInt(scanner.nextLine());
        int sum = 0;



        for (int i = 0; i < numbers; i++) {

            int one = Integer.parseInt(scanner.nextLine());
            sum += one;

        }

        System.out.println(sum);






    }
}
