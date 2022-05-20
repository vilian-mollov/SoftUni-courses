package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class N2Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int division = 0;
        if (number % 2 == 0) {
            division= 2;
        }
        if(number % 3 == 0){
            division= 3;
        }
        if(number % 7 == 0){
            division= 7;
        }
        if(number % 6 == 0){
            division= 6;
        }
        if(number % 10 == 0){
            division= 10;
        }

        if(division>0) {
            System.out.printf("The number is divisible by %d", division);
        }else{
            System.out.println("Not divisible");
        }



    }
}

