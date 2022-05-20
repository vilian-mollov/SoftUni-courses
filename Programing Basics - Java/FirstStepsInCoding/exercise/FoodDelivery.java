package FirstStepsInCoding.exercise;

import java.util.Scanner;

public class FoodDelivery {
    public static void main(String[] args) {
/*

Групата ще си поръча и десерт, чиято цена е равна на 20% от общата сметка (без доставката).
* От конзолата се четат 3 реда:
•	Брой пилешки менюта – цяло число в интервала [0 … 99]
•	Брой менюта с риба – цяло число в интервала [0 … 99]
•	Брой вегетариански менюта – цяло число в интервала [0 … 99]
Изход
Да се отпечата на конзолата един ред:  "{цена на поръчката}"
*
*Цената на доставка е 2.50 лв и се начислява най-накрая.
*
*
* */
Scanner scanner = new Scanner(System.in);

int chicken = Integer.parseInt(scanner.nextLine());
        int fish = Integer.parseInt(scanner.nextLine());
        int vegan = Integer.parseInt(scanner.nextLine());
        double chickenPrice = chicken * 10.35;
        double fishPrice = fish * 12.40;
        double veganPrice = vegan * 8.15;

        double totalPrice = chickenPrice + fishPrice + veganPrice;
        double plusDesert = totalPrice * 0.20;
        double totalTotalWithoutDelivery = plusDesert + totalPrice;
        double totalTotal = totalTotalWithoutDelivery + 2.50;
        System.out.println(totalTotal);

    }

}
