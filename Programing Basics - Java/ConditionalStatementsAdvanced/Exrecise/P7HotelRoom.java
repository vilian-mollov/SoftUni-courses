package ConditionalStatementsAdvanced.Exrecise;

import java.util.Scanner;

public class P7HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());
        double studio = 0.0;
        double apartment = 0.0;
        double discount = 0.0;


        switch (month) {
            case "May":
            case "October":

                studio = 50.0;
                apartment = 65.0;

                if(nights > 14) {
                    discount = 0.90;
                    System.out.printf("Apartment: %.2f lv.%n", nights * apartment * discount);
                }else {

                    System.out.printf("Apartment: %.2f lv.%n", nights * apartment);
                }

                if (nights > 7 && nights <= 14) {
                    discount = 0.95;
                    System.out.printf("Studio: %.2f lv.", nights * studio * discount);

                } else if (nights > 14) {
                    discount = 0.70;
                    System.out.printf("Studio: %.2f lv.", nights * studio * discount);

                }else {
                    System.out.printf("Studio: %.2f lv.", nights * studio);

                }


                break;
            case "June":
            case "September":
                studio = 75.20;
                apartment = 68.70;

                if(nights > 14) {
                    discount = 0.90;
                    System.out.printf("Apartment: %.2f lv.%n", nights * apartment * discount);
                }else {

                    System.out.printf("Apartment: %.2f lv.%n", nights * apartment);
                }

                if(nights > 14) {
                    discount = 0.80;
                    System.out.printf("Studio: %.2f lv.", nights * studio * discount);

                }else {
                    System.out.printf("Studio: %.2f lv.", nights * studio);

                }


                break;
            case "July":
            case "August":
                studio = 76.0;
                apartment = 77.0;

                if(nights > 14) {
                    discount = 0.90;
                    System.out.printf("Apartment: %.2f lv.%n", nights * apartment * discount);
                }else {

                    System.out.printf("Apartment: %.2f lv.%n", nights * apartment);
                }

                System.out.printf("Studio: %.2f lv.", nights * studio);




                break;
        }


    }
}
