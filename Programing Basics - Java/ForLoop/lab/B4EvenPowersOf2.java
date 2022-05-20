package ForLoop.lab;

import java.util.Scanner;

public class B4EvenPowersOf2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i <= number; i++) {


            if(i % 2 == 0){

                System.out.printf("%.0f %n",Math.pow(2,i));

            }

            
        }
    }
}
