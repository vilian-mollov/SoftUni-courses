package DataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class N2FromLeftToTheRight {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
        short numberOfRepetitions = Short.parseShort(scanner.nextLine());


        for (int i = 1; i <= numberOfRepetitions; i++) {
            String input = scanner.nextLine();
            long maxie = Long.MIN_VALUE;

            String[] numbersAsStrings = input.split("\\s");
            for (String s : numbersAsStrings) {
                long currentNumber = Long.parseLong(s);
                if (currentNumber > maxie) {
                    maxie = currentNumber;
                }

            }
            String stringOfMaxie = maxie + "";
            String[] arrayOfMaxie = stringOfMaxie.split("|");
            String newString = "";
            for (int j = 0; j <arrayOfMaxie.length ; j++) {
                newString = newString + arrayOfMaxie[j];
            }
            newString = newString.replaceAll("-", "");
            //newString = newString.replaceAll("\\+", ""); - it may get in use???
String[] arrayOfNewString = newString.split("|");


            int collector = 0;

            for (String element : arrayOfNewString) {

                collector += Integer.parseInt(element);
            }

            System.out.println(collector);


        }


    }
}