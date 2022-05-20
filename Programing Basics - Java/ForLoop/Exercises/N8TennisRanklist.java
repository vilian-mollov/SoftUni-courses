package ForLoop.Exercises;

import java.util.Scanner;

public class N8TennisRanklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfTournaments = Integer.parseInt(scanner.nextLine());
        int startingPoints = Integer.parseInt(scanner.nextLine());
        double pointsOfGrisho = 0.0;
        double wonTournaments = 0.0;

        for (int i = 1; i <= numberOfTournaments ; i++) {

            String placeInTournament = scanner.nextLine();

            switch(placeInTournament){

                case "W":
                   pointsOfGrisho += 2000;
                    wonTournaments ++;
                    break;
                case "F":
                   pointsOfGrisho += 1200;
                    break;
                case "SF":
                    pointsOfGrisho+=720;
                    break;

            }

        }


        System.out.printf("Final points: %.0f%n", pointsOfGrisho + startingPoints);
        System.out.printf("Average points: %.0f%n", Math.floor(pointsOfGrisho / numberOfTournaments));
        System.out.printf("%.2f%%", wonTournaments / numberOfTournaments * 100 );







    }
}
