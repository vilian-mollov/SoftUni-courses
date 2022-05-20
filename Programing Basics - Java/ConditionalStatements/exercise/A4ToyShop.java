package ConditionalStatements.exercise;

import java.util.Scanner;

public class A4ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //40.8
        //20
        //25
        //30
        //50
        //10

        double priceOfExcursion = Double.parseDouble(scanner.nextLine());
        int puzzles = Integer.parseInt(scanner.nextLine());
        int talkingDolls = Integer.parseInt(scanner.nextLine());
        int teddyBears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());

        double numberOfToys = puzzles + talkingDolls +teddyBears + minions +trucks;
        double discount = 0.0;
        double priceTotalWithoutDiscount = puzzles *2.60 + talkingDolls *3 + teddyBears *4.10 + minions *8.20 + trucks *2;

        if (numberOfToys >= 50){
            discount = priceTotalWithoutDiscount * 0.25;
        }
        double totalPrice = priceTotalWithoutDiscount - discount ;
        double moneyLeftForExcursion = totalPrice - (totalPrice * 0.10);

        if(moneyLeftForExcursion >= priceOfExcursion){
            double price = moneyLeftForExcursion - priceOfExcursion;

            System.out.printf("Yes! %.2f lv left.", price );

        }else {
            double price = moneyLeftForExcursion - priceOfExcursion;
            price = Math.abs(price);
            System.out.printf("Not enough money! %.2f lv needed.", price );


        }




    }
}
