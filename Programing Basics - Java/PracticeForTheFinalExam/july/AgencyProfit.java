package PracticeForTheFinalExam.july;

import java.util.Scanner;

public class AgencyProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameOfCompany = scanner.nextLine();
        int adultsTickets = Integer.parseInt(scanner.nextLine());
        int childrenTickets = Integer.parseInt(scanner.nextLine());
        double netPriceForAdult = Double.parseDouble(scanner.nextLine());
        double serviceTax =  Double.parseDouble(scanner.nextLine());

        double netPriceForChildren = netPriceForAdult * 0.70;
double totalPrice = (adultsTickets * netPriceForAdult + childrenTickets *  netPriceForChildren) *0.20;


        System.out.printf("The profit of your agency from %s tickets is %.2f lv.", nameOfCompany , totalPrice + serviceTax );

    }
}
