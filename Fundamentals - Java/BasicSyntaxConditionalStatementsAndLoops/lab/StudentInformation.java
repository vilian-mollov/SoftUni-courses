package BasicSyntaxConditionalStatementsAndLoops.lab;

import java.util.Scanner;

public class StudentInformation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        double grade = scanner.nextDouble();


        System.out.printf("Name: %s, Age: %d, Grade: %.2f",name,age,grade);




    }
}
