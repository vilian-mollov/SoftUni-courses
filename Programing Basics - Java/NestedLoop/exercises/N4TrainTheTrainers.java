package NestedLoop.exercises;

import java.util.Scanner;

public class N4TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfJudges = Integer.parseInt(scanner.nextLine());
        String nameOfPresentation = scanner.nextLine();
        double wholeSum =0.0;
        int counter = 0;
        while (!nameOfPresentation.equals("Finish")){
            double sum = 0.0;
            int s = 0;
            for (int i = 1; i <= numberOfJudges ; i++) {
                double grade = Double.parseDouble(scanner.nextLine());
                sum += grade;
                wholeSum +=grade;
                counter ++;
                s ++;

            }

            System.out.printf("%s - %.2f.%n", nameOfPresentation, sum / s);

            nameOfPresentation= scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", wholeSum / counter);
    }
}
