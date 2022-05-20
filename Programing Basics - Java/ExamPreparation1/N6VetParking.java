package ExamPreparation1;

import java.util.Scanner;

public class N6VetParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfDays = Integer.parseInt(scanner.nextLine());
        int numberOfHours = Integer.parseInt(scanner.nextLine());
        double total = 0.0;

        for (int i = 1; i <= numberOfDays ; i++) {
                    double tax =0.0;
            for (int j = 1; j <=numberOfHours ; j++) {

                if(i % 2 == 0){
                    if(j % 2 == 0){
                        tax += 1;
                    }else{
                        tax += 2.50;
                    }

                }else{
                    if(j % 2 == 0){
                        tax += 1.25;
                    }else{
                        tax += 1;
                    }

                }

            }
            total += tax;
            System.out.printf("Day: %d - %.2f leva%n", i,tax);

        }

        System.out.printf("Total: %.2f leva", total);
    }
}
