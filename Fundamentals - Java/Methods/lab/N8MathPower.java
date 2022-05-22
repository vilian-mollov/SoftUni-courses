package Methods.lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class N8MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());

      double result =  calculatingPowerOfNumber(number,power);
        System.out.println(new DecimalFormat("0.####").format(result));
    }

    private static double calculatingPowerOfNumber(double number, int power) {
        double result=Math.pow(number,power);

        return result;
    }
}
