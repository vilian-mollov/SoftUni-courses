package WhileLoop.exercises;

import java.util.Scanner;

public class walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean madeIt = false;
        int totalSteps = 0;
        String action = scanner.nextLine();
        while (!action.equals("Going home")) {
            int stepsMade = Integer.parseInt(action);
            totalSteps += stepsMade;

            if (totalSteps >= 10000) {
                madeIt = true;
                break;
            }

            action = scanner.nextLine();
        }
        if(totalSteps < 10000) {
            int steps = Integer.parseInt(scanner.nextLine());
            totalSteps += steps;
        }
        if (totalSteps >= 10000) {
            madeIt = true;
        }


        if (madeIt) {
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!",Math.abs(totalSteps - 10000)  );

        } else {
            System.out.printf("%d more steps to reach goal.",Math.abs( 10000 - totalSteps));


        }


    }
}
