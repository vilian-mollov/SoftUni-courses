package ForLoop.Exercises;

import java.util.Scanner;

public class N4CleverLily {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double laundry = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());

        double sum = 0;
        int toys = 0;
        int cash = 10;

        for (int i = 1; i <= age ; i++) {



            if(i % 2 == 0){
                sum += cash;
                cash += 10;
                sum -= 1;

            }else {

            toys++;

            }

        }


        sum += toys * toyPrice;


        if( sum >= laundry ){
            System.out.printf("Yes! %.2f", Math.abs(laundry - sum) );

        }else{

            System.out.printf("No! %.2f", Math.abs(laundry - sum) );

        }



    }
}
