package FirstStepsInCoding.exercise;

import java.util.Scanner;

public class USDtoBGN {
    public static void main(String[] args) {

//конвертиране на щатски долари (USD) в български лева (BGN).
        //курс 1 USD = 1.79549 BGN
        // входни данни от конзолата щатски долари

        Scanner scanner = new Scanner(System.in);

        double dollar = Double.parseDouble(scanner.nextLine());
                double cursLeva = dollar * 1.79549;
        System.out.println(cursLeva);




    }
}
