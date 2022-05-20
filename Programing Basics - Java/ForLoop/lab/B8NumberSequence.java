package ForLoop.lab;

import java.util.Scanner;

public class B8NumberSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int maxNumber = Integer.MIN_VALUE;
        int minNumber = Integer.MAX_VALUE;


        for (int i = 0; i < count; i++) {

            int number = Integer.parseInt(scanner.nextLine());

            if(number > maxNumber ) {

                maxNumber = number;
            }

            if(number < minNumber){
                minNumber = number;
            }


        }
        System.out.printf("Max number: %d%n",maxNumber);
        System.out.printf("Min number: %d%n",minNumber);




    }

}
