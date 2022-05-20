package MoreExercises;

import java.util.Scanner;

public class MatchTickets {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double moneyTheyHave = Double.parseDouble(scanner.nextLine());
        String kindOfTickets = scanner.nextLine();
        int numberOfPeople = Integer.parseInt(scanner.nextLine());


double priceOfOneTicket = 0;

        if(numberOfPeople <= 4){
            moneyTheyHave -= moneyTheyHave * 0.75;

        }else if(numberOfPeople <= 9){
            moneyTheyHave -= moneyTheyHave * 0.60;

        }else if(numberOfPeople <= 24){
            moneyTheyHave -= moneyTheyHave * 0.50;

        }else if(numberOfPeople <= 49){
            moneyTheyHave -= moneyTheyHave * 0.40;


        }else {
            moneyTheyHave -= moneyTheyHave * 0.25;
        }
        if(kindOfTickets.equals("VIP")) {
                priceOfOneTicket = 499.99;

            if (moneyTheyHave >= priceOfOneTicket*numberOfPeople) {
                System.out.printf("Yes! You have %.2f leva left.", moneyTheyHave - priceOfOneTicket*numberOfPeople);

            }else {
                System.out.printf("Not enough money! You need %.2f leva.", priceOfOneTicket* numberOfPeople - moneyTheyHave);
            }


        }else if(kindOfTickets.equals("Normal")){
            priceOfOneTicket = 249.99;

            if (moneyTheyHave >= priceOfOneTicket*numberOfPeople) {
                System.out.printf("Yes! You have %.2f leva left.", moneyTheyHave - priceOfOneTicket*numberOfPeople);

            }else {
                System.out.printf("Not enough money! You need %.2f leva.", priceOfOneTicket* numberOfPeople - moneyTheyHave);
            }


        }






    }


}
