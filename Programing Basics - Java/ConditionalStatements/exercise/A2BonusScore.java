package ConditionalStatements.exercise;

import java.util.Scanner;

public class A2BonusScore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingPoints = Integer.parseInt(scanner.nextLine());

        if (startingPoints <= 100){
            if (startingPoints % 2 == 0){

            double bonus = 5 + 1;
            double pointsWillBe = startingPoints  + bonus;
            System.out.println(bonus);
            System.out.println(pointsWillBe);}
            else if(startingPoints % 10 == 5){
                double bonus = 5 + 2;
                double pointsWillBe = startingPoints  + bonus;
                System.out.println(bonus);
                System.out.println(pointsWillBe);
            }else {

                double bonus = 5;
                double pointsWillBe = startingPoints  + bonus;
                System.out.println(bonus);
                System.out.println(pointsWillBe);

            }

        } else if (startingPoints <= 1000){



            if (startingPoints % 2 == 0){

                double bonus =(startingPoints * 0.20) +1 ;
                double pointsWillBe = startingPoints  + bonus;
                System.out.println(bonus);
                System.out.println(pointsWillBe);}
            else if(startingPoints % 10 == 5){
                double bonus = startingPoints * 0.20 + 2;
                double pointsWillBe = startingPoints  + bonus;
                System.out.println(bonus);
                System.out.println(pointsWillBe);


            } else {

                double bonus = startingPoints * 0.20;
                double pointsWillBe = startingPoints  + bonus;
                System.out.println(bonus);
                System.out.println(pointsWillBe);


            }







        } else{




            if (startingPoints % 2 == 0){

                double bonus =(startingPoints * 0.10) +1 ;
                double pointsWillBe = startingPoints  + bonus;
                System.out.println(bonus);
                System.out.println(pointsWillBe);}
            else if(startingPoints % 10 == 5){
                double bonus = startingPoints * 0.10 + 2;
                double pointsWillBe = startingPoints  + bonus;
                System.out.println(bonus);
                System.out.println(pointsWillBe);


            }else {

                double bonus = startingPoints * 0.10;
                double pointsWillBe = startingPoints  + bonus;
                System.out.println(bonus);
                System.out.println(pointsWillBe);

            }






        }



    }
}
