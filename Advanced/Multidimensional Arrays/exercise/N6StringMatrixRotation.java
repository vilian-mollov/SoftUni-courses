package MultidimensionalArrays.exercise;

import java.util.Scanner;

public class N6StringMatrixRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] commandData = scanner.nextLine().split("[\\(\\)]");

        String command = commandData[0];
        int number = Integer.parseInt(commandData[1]);

        if (command.equals("Rotate")) {

            if (number == 0) {
                //print it that way
            }
            double value = (number * 1.00) / 90;
            if(value == 1) {
                //NINETY enum

            }else{
                double degreeValue = value / 4;
                int degreeValueWhole = (int)value / 4;
                int remainder = (int)(degreeValue * 100) - degreeValueWhole * 100;
                System.out.println();
                switch(remainder){
                    case 25:
                        // 90
                        break;
                    case 50:
                        //180
                        break;
                    case 75:
                        //270
                        break;
                    case 0:
                        //360
                        break;
                }


            }



        }


    }

    enum Degree {
        NINETY(90),
        ONE_EIGHTY(180),
        TWO_SEVENTY(270),
        THREE_SIXTY(360);

        int degree;

        Degree(int degree) {
            this.degree = degree;
        }
    }

}
