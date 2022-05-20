package WhileLoop.exercises;

import java.util.Scanner;

public class coins2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        double sum = Double.parseDouble(scanner.nextLine());

        sum = Math.floor(sum * 100);
        int coins = 0;

        while(sum > 0){
            coins++;

            if(sum>= 200){
                sum -= 200;
            }else if(sum >= 100){
                sum -= 100;

            }else if(sum >= 50){
                sum -= 50;
            }else if(sum >= 20){
                sum -= 20;
            }else if(sum >= 10){
                sum -= 10;
            }else if(sum >= 5){
                sum -= 5;
            }else if(sum >= 2){
                sum -= 2;
            }else {
                sum -=1;
            }


        }

        System.out.println(coins);
    }
}
