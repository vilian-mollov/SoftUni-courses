package ConditionalStatements.lab;

import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String figure = scanner.nextLine();

        if(figure.equals("square")){
            double sideOfSquare = Double.parseDouble(scanner.nextLine());
            double formula2 = sideOfSquare *  sideOfSquare;
            System.out.printf("%.3f", formula2);


        }else if(figure.equals("rectangle")){
            double sideOfRectangle = Double.parseDouble(scanner.nextLine());
            double sideOfRectangle2 = Double.parseDouble(scanner.nextLine());
            double formula1 = sideOfRectangle * sideOfRectangle2;
            System.out.printf("%.3f", formula1 );

        }else if(figure.equals("circle")){

            double radiusOfCircle = Double.parseDouble(scanner.nextLine());
            double formula = (radiusOfCircle * radiusOfCircle) * Math.PI ;
            System.out.printf("%.3f",formula);


        }else if(figure.equals("triangle")){

            double sideOfTriangle = Double.parseDouble(scanner.nextLine());
            double heightOFTriangle = Double.parseDouble(scanner.nextLine());
            double formulaT = sideOfTriangle * heightOFTriangle / 2;
            System.out.printf("%.3f", formulaT);

        }




    }
}
