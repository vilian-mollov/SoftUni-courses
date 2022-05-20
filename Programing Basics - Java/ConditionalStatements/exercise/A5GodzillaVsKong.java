package ConditionalStatements.exercise;

import java.util.Scanner;

public class A5GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int numberOfStatists = Integer.parseInt(scanner.nextLine());
        double priceOfClothsForOneStatist = Double.parseDouble(scanner.nextLine());

        double decor = budget * 0.10;
        double priceOfClothsTotal = priceOfClothsForOneStatist * numberOfStatists;
        if(numberOfStatists > 150){

            priceOfClothsTotal *= 0.90;

        }

        double totalCost = decor + priceOfClothsTotal;

        if(totalCost <= budget){
            System.out.println("Action!" );
            System.out.printf("Wingard starts filming with %.2f leva left.",budget - totalCost);

        }else {

            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", totalCost - budget);

        }





    }
}
