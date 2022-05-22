package Methods.lab;

import java.util.Scanner;

public class N9GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeOfValues = scanner.nextLine();
        int numberOne;
        int numberTwo;
        String charNumberOne;
        String charNumberTwo;
        String stringOne;
        String stringTwo;

        switch (typeOfValues) {
            case "int":
                numberOne = Integer.parseInt(scanner.nextLine());
                numberTwo = Integer.parseInt(scanner.nextLine());
                getMax(numberOne,numberTwo);
                break;
            case "char":
                charNumberOne = scanner.nextLine();
                charNumberTwo = scanner.nextLine();
                getMax(charNumberOne.charAt(0),charNumberTwo.charAt(0));
                break;
            case "string":
                stringOne = scanner.nextLine();
                stringTwo = scanner.nextLine();
                String result = getMax(stringOne,stringTwo);
                System.out.println(result);
                break;
        }
    }

    private static void getMax(char charNumberOne, char charNumberTwo) {
        System.out.println((char)Math.max(charNumberOne,charNumberTwo));
    }

    private static void getMax(int n,int ntwo) {
        System.out.println(Math.max(n,ntwo));
    }
    private static String getMax(String first, String second) {
        if(first.compareTo(second) >=0){
            return first;
        }
        return second;

    }

}
