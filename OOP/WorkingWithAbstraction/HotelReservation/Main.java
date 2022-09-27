package WorkingWithAbstraction.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(data[0]);
        int numberOfDays = Integer.parseInt(data[1]);
        Season season = Season.parse(data[2]);
        DiscountType discount = DiscountType.parse(data[3]);


        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay, numberOfDays,
                season, discount);

        System.out.printf("%.2f", priceCalculator.getTotalPrice());

    }
}
