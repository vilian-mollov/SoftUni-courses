package WhileLoop.lab;

import java.util.Scanner;

public class R3SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberCheck = Integer.parseInt(scanner.nextLine());



        int sum = 0;
        while( sum < numberCheck){

            int number = Integer.parseInt(scanner.nextLine());
            sum += number;
        }
        System.out.println(sum);


    }

}
