package ConditionalStatements.exercise;

import java.util.Scanner;

public class A7Shopping {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budged = Double.parseDouble(scanner.nextLine());
        int videoCards =Integer.parseInt(scanner.nextLine());
        int processors =Integer.parseInt(scanner.nextLine());
        int ramMemory =Integer.parseInt(scanner.nextLine());
        double videoCardsPrice = videoCards * 250;
        double processorsPrice = (videoCardsPrice * 0.35) * processors;
        double ramMemoryPrice = (videoCardsPrice * 0.10) * ramMemory;
double total = videoCardsPrice + processorsPrice + ramMemoryPrice;

        if(videoCards > processors){
            total *= 0.85;

        }

if(budged >= total){

    System.out.printf("You have %.2f leva left!",budged - total );
}else{

    System.out.printf("Not enough money! You need %.2f leva more!",total - budged);
}






    }
}
