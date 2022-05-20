package ExamPreparation1;

import java.util.Scanner;

public class N1MovieProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfMovie = scanner.nextLine();
        int numberOfDays = Integer.parseInt(scanner.nextLine());
        int numberOfTickets = Integer.parseInt(scanner.nextLine());
        double  priceOfTicket= Double.parseDouble(scanner.nextLine());
        int percentageForTheCinema = Integer.parseInt(scanner.nextLine());
        double x = numberOfTickets * priceOfTicket;
        double total = x * numberOfDays;
        double profitForCinema = total * percentageForTheCinema / 100;


        System.out.printf("The profit from the movie %s is %.2f lv.",nameOfMovie,total -profitForCinema);
    }
}
