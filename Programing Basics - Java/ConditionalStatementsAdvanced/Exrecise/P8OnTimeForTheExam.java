package ConditionalStatementsAdvanced.Exrecise;

import java.util.Scanner;

public class P8OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hourOfExam = Integer.parseInt(scanner.nextLine());
        int minuteOfExam = Integer.parseInt(scanner.nextLine());
        int hourOfArriving = Integer.parseInt(scanner.nextLine());
        int minuteOfArriving = Integer.parseInt(scanner.nextLine());

        int exTime = hourOfExam * 60 + minuteOfExam;
        int arTime = hourOfArriving * 60 + minuteOfArriving;
        String output = "";
        String status = "";


        if (arTime < exTime - 30) {
            status = "Early";
            int dif = exTime - arTime;
            if (dif < 60) {
                output = String.format("%d minutes before the start", dif);
            } else {
                int h = dif / 60;
                int m = dif % 60;
                output = String.format("%d:%02d hours before the start",h,m);
            }

        } else if (arTime <= exTime) {
            status = "On time";
            int dif = exTime - arTime;
            output = String.format("%d minutes before the start",dif);

        } else {

            status = "Late";
            int dif = arTime - exTime;
            int h = dif / 60;
            int m = dif % 60;
            if (dif < 60) {
                output = String.format("%d minutes after the start", dif);
            } else {

                output = String.format("%d:%02d hours after the start",h,m);
            }

        }
        System.out.println(status);
        System.out.println(output);


    }
}
