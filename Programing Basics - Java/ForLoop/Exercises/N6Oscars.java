package ForLoop.Exercises;

import java.util.Scanner;

public class N6Oscars {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String actorName = scanner.nextLine();
        double pointsFromAcademy = Double.parseDouble(scanner.nextLine());
        int numberOfJudges = Integer.parseInt(scanner.nextLine());
        double totalPoints = 0;
        totalPoints += pointsFromAcademy;


        for (int i = 0; i < numberOfJudges; i++) {

                if(totalPoints < 1250.5) {
                    String nameOfJudge = scanner.nextLine();
                    double pointsOfJudge = Double.parseDouble(scanner.nextLine());
                    totalPoints +=( pointsOfJudge * nameOfJudge.length()) / 2;
                }

        }




            if(totalPoints >= 1250.5){
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actorName , totalPoints);

            }else{

                System.out.printf("Sorry, %s you need %.1f more!", actorName , Math.abs(totalPoints - 1250.5));
            }




    }
}
