package ForLoop.Exercises;

import java.util.Scanner;

public class N5Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int openTabs = Integer.parseInt(scanner.nextLine());
        int salary = Integer.parseInt(scanner.nextLine());
        int penalty = 0;


        for (int i = 1; i <= openTabs ; i++) {
            String websiteName = scanner.nextLine();
            switch(websiteName){
                case "Facebook":
                    penalty += 150;
                    break;
                case "Instagram":
                    penalty += 100;
                    break;
                case "Reddit":
                    penalty += 50;
                    break;

            }
        }
        if(salary > penalty){

            System.out.printf("%d", salary - penalty);

        }else{

            System.out.println("You have lost your salary.");

        }





    }
}
