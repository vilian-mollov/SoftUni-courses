package WhileLoop.exercises;

import java.util.Scanner;

public class N2ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int badGrades = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        int tasks = 0;
        double gradesTotal =0.0;
        boolean failed = false;
        String lastExercise = "";
        String nameOfExercise = scanner.nextLine();


        while(!nameOfExercise.equals("Enough")){
            int grade = Integer.parseInt(scanner.nextLine());
            gradesTotal += grade;
            lastExercise = nameOfExercise;
            if(grade <= 4){
                counter++;
                if(counter == badGrades){
                    failed = true;
                    break;
                }
            }
            tasks ++;


            nameOfExercise = scanner.nextLine();

        }

        if(failed){
            System.out.printf("You need a break, %d poor grades.", counter);

        }else {
            System.out.printf("Average score: %.2f%n",gradesTotal / tasks);
            System.out.printf("Number of problems: %d%n", tasks);
            System.out.printf("Last problem: %s",lastExercise);

        }


    }
}
