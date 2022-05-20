package FirstStepsInCoding.exercise;

import java.util.Scanner;

public class BasketballEquipment {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int priceYear = Integer.parseInt(scanner.nextLine());
        double basketballSneakers = priceYear * 0.40;
        double sneakersPrice = priceYear - basketballSneakers;
        double basketballEquip = sneakersPrice * 0.20;
        double equipPrice = sneakersPrice - basketballEquip;
        double ballBasketball = equipPrice * 0.25;
        double basketballAccessories = ballBasketball * 0.20;

        double totalTotal = sneakersPrice + equipPrice + ballBasketball + basketballAccessories + priceYear;
        System.out.println(totalTotal);


    }

}
