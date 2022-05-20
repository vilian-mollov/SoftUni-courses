package WhileLoop.exercises;

import java.util.Scanner;

public class coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = Double.parseDouble(scanner.nextLine());
        int coinsReceived = 0;
        double changeYellowCoin = sum % 1;
        double wholeCoins = sum - changeYellowCoin;

        if(wholeCoins >= 2){
            if(wholeCoins % 2 == 0){
           coinsReceived += wholeCoins /2;

        }else{

                coinsReceived += Math.floor(wholeCoins /2);
                coinsReceived++;

            }
        }
        if(wholeCoins == 1){
            coinsReceived ++;
        }

        changeYellowCoin = Math.floor(changeYellowCoin * 100);



        while(changeYellowCoin > 0.0){

            if(changeYellowCoin >= 50){
                changeYellowCoin -= 50;
                coinsReceived ++;
            }
            if(changeYellowCoin < 50 && changeYellowCoin >= 40){
                changeYellowCoin -= 40;
                coinsReceived += 2;

            }
            if(changeYellowCoin < 40 && changeYellowCoin >= 20){
                changeYellowCoin -= 20;
                coinsReceived ++;
            }
            if(changeYellowCoin < 20 && changeYellowCoin >=10){
                changeYellowCoin -= 10;
                coinsReceived ++;
            }
            if(changeYellowCoin < 10 && changeYellowCoin >= 5){
                changeYellowCoin -= 5;
                coinsReceived ++;
            }
            if(changeYellowCoin < 5 && changeYellowCoin >= 2){
                changeYellowCoin -= 2;
                coinsReceived +=1;
                            }
            if(changeYellowCoin >=2){
                changeYellowCoin -= 2;
                coinsReceived +=1;

            }
            if(changeYellowCoin == 2){
                changeYellowCoin -= 2;
                coinsReceived ++;
            }
            if(changeYellowCoin < 2 && changeYellowCoin > 0){
                changeYellowCoin -= 1;
                coinsReceived++;
            }


        }

        System.out.println(coinsReceived);



    }
}
