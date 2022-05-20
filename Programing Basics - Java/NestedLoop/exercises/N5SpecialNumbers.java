package NestedLoop.exercises;

import java.util.Scanner;

public class N5SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1111; i <=9999 ; i++) {

            String number = "" + i;
            int counter = 0;

            for (int j = 0; j < number.length() ; j++) {
                int x = Integer.parseInt(""+ number.charAt(j));
                if(x == 0){
                    continue;
                }

                if(n % x == 0){
                    counter++;
                }


            }
            if(counter == 4){
                System.out.printf("%s ",number);
            }

        }

    }
}
