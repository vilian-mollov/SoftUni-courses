package FirstStepsInCoding.exercise;

import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {
        //пакетчета с химикали, пакетчета с маркери, както и препарат за почистване на дъска
        //има намаление - някакъв процент от общата сума.
        //	Пакет химикали - 5.80 лв.
        //	Пакет маркери - 7.20 лв.
        //	Препарат - 1.20 лв (за литър)
        //От конзолата се четат 4 числа:
        //	Брой пакети химикали
        //	Брой пакети маркери
        //Литри препарат за почистване на дъска - цяло число в интервала [0…50]
        //Процент намаление - цяло число в интервала [0...100]


        Scanner scanner = new Scanner(System.in);
        int pencils = Integer.parseInt(scanner.nextLine());
        int markers = Integer.parseInt(scanner.nextLine());
        int chemicals = Integer.parseInt(scanner.nextLine());
        int percentageDiscount = Integer.parseInt(scanner.nextLine());
        double penPrice = pencils * 5.80;
        double markerPrice = markers * 7.20;
        double chemicalsPrice = chemicals * 1.20;
        double realPercentageDiscount = percentageDiscount * 0.01;
        double  totalPrice = (penPrice + markerPrice + chemicalsPrice);
        double discountFromPrice = totalPrice * realPercentageDiscount;
        double totalPlusDiscount = totalPrice - discountFromPrice;

        System.out.println(totalPlusDiscount);


    }
}
