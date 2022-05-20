package FirstStepsInCoding.exercise;

import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double  depositSum = Double.parseDouble(scanner.nextLine());
        int mounts = Integer.parseInt(scanner.nextLine());
        double yearlyInterestProcent = Double.parseDouble(scanner.nextLine());
        double realprocentage = yearlyInterestProcent /100;

        double mountlyInterest = depositSum * realprocentage /12;
        double totalSum = depositSum + mounts * mountlyInterest;

        System.out.println(totalSum);






    }

}
