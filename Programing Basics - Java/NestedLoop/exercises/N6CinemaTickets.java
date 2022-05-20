package NestedLoop.exercises;

import java.util.Scanner;

public class N6CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfMovie = scanner.nextLine();
        int totalTicketsBought = 0;
        int student = 0;
        int standard = 0;
        int kid = 0;

        while (!nameOfMovie.equals("Finish")) {

            int freePlaces = Integer.parseInt(scanner.nextLine());
            String ticket = scanner.nextLine();
            int places = 0;

            while (!ticket.equals("End")) {
                places++;
                totalTicketsBought++;

                switch (ticket) {
                    case "student":
                        student++;
                        break;
                    case "standard":
                        standard++;
                        break;
                    case "kid":
                        kid++;
                        break;
                }

                if (places >= freePlaces) {
                    break;
                }


                ticket = scanner.nextLine();
            }
                System.out.printf("%s - %.2f%% full.%n", nameOfMovie, places * 1.0 / freePlaces * 100);

            nameOfMovie = scanner.nextLine();
        }
        System.out.printf("Total tickets: %d%n", totalTicketsBought);
        System.out.printf("%.2f%% student tickets.%n", student * 1.0 / totalTicketsBought * 100);
        System.out.printf("%.2f%% standard tickets.%n", standard * 1.0 / totalTicketsBought * 100);
        System.out.printf("%.2f%% kids tickets.%n", kid * 1.0 / totalTicketsBought * 100);


    }
}
