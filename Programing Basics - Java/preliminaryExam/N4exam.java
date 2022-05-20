package preliminaryExam;

import java.util.Scanner;

public class N4exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfDays = Integer.parseInt(scanner.nextLine());
        double kilometersNeeded = Double.parseDouble(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        double x = kilometersNeeded + kilometersNeeded * n / 100;

        double total = x + kilometersNeeded;

        double y = 0.0;

        for (int i = 1; i < numberOfDays; i++) {
            int numb = Integer.parseInt(scanner.nextLine());

            if(i == 1){
                y =x;
            }
                y = y + y * numb / 100;


            total += y;


        }


        if (total >= 1000) {
            System.out.printf("You've done a great job running %.0f more kilometers!", Math.ceil(total - 1000));
        } else {
            System.out.printf("Sorry Mrs. Ivanova, you need to run %.0f more kilometers", Math.ceil(1000 - total));
        }
    }
}
