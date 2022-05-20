package WhileLoop.lab;

import java.util.Scanner;

public class R8Graduation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();


        int count = 0;
        int classR = 1;
        double collectGrades = 0.0;
        while(classR <= 12){
            double grade = Double.parseDouble(scanner.nextLine());

            if(grade >= 4.00){

                collectGrades += grade;



            }else{

               count ++;
            }
            if(count == 2){
                System.out.printf("%s has been excluded at %d grade%n", name , classR -1);
                break;
            }

        classR ++;
        }

        if(count != 2) {
            System.out.printf("%s graduated. Average grade: %.2f", name, collectGrades / 12);
        }

    }
}
