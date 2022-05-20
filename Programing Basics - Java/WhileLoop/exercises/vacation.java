package WhileLoop.exercises;

import java.util.Scanner;

public class vacation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double moneyNeededForExcursion = Double.parseDouble(scanner.nextLine());
        double herMoney = Double.parseDouble(scanner.nextLine());
        double money = 0.0;
        money += herMoney;
        int counter = 0;
        int days = 0;


        String action = scanner.nextLine();

        while(money < moneyNeededForExcursion && counter < 5){
            double theSum = Double.parseDouble(scanner.nextLine());
            if(action.equals("spend")){
                money -= theSum;
                if(money < 0){
                    money = 0;
                }

                counter ++;
                if(counter == 5){
                    days ++;
                    break;
                }


            }else{
                money += theSum;
                counter = 0;

            }

            days ++;
            if(money >= moneyNeededForExcursion){
                break;
            }
            action = scanner.nextLine();
        }

        if(money >= moneyNeededForExcursion){
            System.out.printf("You saved the money for %d days.", days);

        }else {
            System.out.println("You can't save the money.");
            System.out.printf("%d",days);

        }


    }
}
