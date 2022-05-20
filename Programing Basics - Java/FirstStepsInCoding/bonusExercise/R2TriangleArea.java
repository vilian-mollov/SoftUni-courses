package FirstStepsInCoding.bonusExercise;

import java.util.Scanner;

public class R2TriangleArea {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//Напишете програма, която чете от конзолата страна и височина на триъгълник и пресмята неговото лице.
// Използвайте формулата за лице на триъгълник: area = a * h / 2.
// Форматирате изхода до втория знак след десетичната запетая.
        double side = Double.parseDouble(scanner.nextLine());
        double  height = Double.parseDouble(scanner.nextLine());


        double formula = side * height / 2.00;
        System.out.printf("%.2f", formula);



    }



}
