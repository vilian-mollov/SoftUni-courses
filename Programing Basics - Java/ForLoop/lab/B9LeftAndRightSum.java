package ForLoop.lab;

import java.util.Scanner;

public class B9LeftAndRightSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        int first = 0;
        int second = 0;

        for (int i = 1; i <= count * 2; i++) {

            int number = Integer.parseInt(scanner.nextLine());

            if(i <= count){

                first += number;

            }else {
                second += number;
            }


        }

        if(first == second){

            System.out.printf("Yes, sum = %d", first);

        }else {

            System.out.printf("No, diff = %d",Math.abs(first - second));

        }




    }
}
