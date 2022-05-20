package NestedLoop.exercises;

import java.util.Scanner;

public class N2EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());

        for (int i = number1; i <= number2 ; i++) {
            String currentNumber = "" + i;

            int even = 0;
            int odd = 0;
            for (int j = 1; j <= currentNumber.length() ; j++) {
                int integerNumber = Integer.parseInt("" + currentNumber.charAt(j-1));
                if(j % 2 == 0){
                    even += integerNumber;
                }else{
                    odd += integerNumber;
                }
            }
            if(even == odd){
                System.out.print(currentNumber + " ");
            }




        }



    }
}
