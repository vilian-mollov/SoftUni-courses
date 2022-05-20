package ConditionalStatements.exercise;

import java.util.Scanner;

public class A6WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    double record = Double.parseDouble(scanner.nextLine());
    double distanceInMeters = Double.parseDouble(scanner.nextLine());
    double timeInSecondsForOneMeter = Double.parseDouble(scanner.nextLine());

    double waterResistance = Math.floor(distanceInMeters / 15) * 12.5;


    double time = timeInSecondsForOneMeter * distanceInMeters + waterResistance;

    if (time < record){


        System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.",time);

    }else {

        System.out.printf("No, he failed! He was %.2f seconds slower.",time - record);
    }



    }
}
