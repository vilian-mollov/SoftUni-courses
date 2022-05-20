package NestedLoop.lab;

import java.util.Scanner;

public class N4SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startOfIteration = Integer.parseInt(scanner.nextLine());
        int endOfIteration = Integer.parseInt(scanner.nextLine());
        int magicalNumber = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        boolean flag = true;

        for (int i = startOfIteration; i <=endOfIteration ; i++) {

            for (int j = startOfIteration; j <=endOfIteration ; j++) {
                counter++;
                if (magicalNumber == i + j ){
                    System.out.printf("Combination N:%d (%d + %d = %d)%n", counter,i,j,magicalNumber);
                    flag = false;

                }

            }
            if(!flag){
                break;
            }

        }

        if(flag) {
            System.out.printf("%d combinations - neither equals %d",counter,magicalNumber);
        }
    }
}
