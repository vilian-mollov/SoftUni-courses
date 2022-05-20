package ConditionalStatements.exercise;

import java.util.Scanner;

public class A3TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        int hours = Integer.parseInt(scanner.nextLine());
        double minutes = Integer.parseInt(scanner.nextLine());
        double bonus = 15;

        double totalMinutes =minutes + bonus;
        double minutesRemainder = totalMinutes % 60;
        if(totalMinutes >= 60){

            hours +=1;

        }
        if(hours == 24){

            hours = 0;
        }

        if(minutesRemainder < 10){

            System.out.printf("%d:0%.0f", hours, minutesRemainder);
        }else {
            System.out.printf("%d:%.0f", hours, minutesRemainder);

        }



    }
}
