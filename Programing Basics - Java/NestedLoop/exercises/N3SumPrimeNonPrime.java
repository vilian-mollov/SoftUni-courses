package NestedLoop.exercises;

import java.util.Scanner;

public class N3SumPrimeNonPrime {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String wholeNumbers = scanner.nextLine();
        int prime = 0;
        int nonPrime =0;


        while(!wholeNumbers.equals("stop")){
            boolean primeTime = false;

            int number = Integer.parseInt(wholeNumbers);
            if(number < 0){
                System.out.println("Number is negative.");
                wholeNumbers = scanner.nextLine();
                continue;
            }
            for (int i = 2; i < number ; i++) {

                if(number % i == 0){

                    primeTime = true;
                    break;
                }



            }
            if(primeTime){
                nonPrime += number;
            }else {
                prime += number;
            }




            wholeNumbers = scanner.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d%n", prime);
        System.out.printf("Sum of all non prime numbers is: %d", nonPrime);

    }
}
