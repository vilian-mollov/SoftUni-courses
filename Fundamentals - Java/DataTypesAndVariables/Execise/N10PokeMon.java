package DataTypesAndVariables.Execise;

import java.math.BigInteger;
import java.util.Scanner;

public class N10PokeMon {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
        BigInteger pokePower = new BigInteger(scanner.nextLine());
        BigInteger distanceBetweenTargets = new BigInteger(scanner.nextLine());
        BigInteger exhaustionFactor = new BigInteger(scanner.nextLine());

        BigInteger currentPower;
        currentPower = pokePower;

        int counterOfPokes = 0;
        BigInteger zero;
        zero = BigInteger.valueOf(0);

        while (currentPower.compareTo(distanceBetweenTargets) >= 0) {


            currentPower = currentPower.subtract(distanceBetweenTargets);
            counterOfPokes++;

            if (currentPower.equals(pokePower.divide(BigInteger.valueOf(2)))&& exhaustionFactor.compareTo(zero) > 0) {

                if (currentPower.compareTo(exhaustionFactor) > 0) {
                    currentPower = currentPower.divide(exhaustionFactor);

                }

            }

        }


        System.out.println(currentPower);
        System.out.println(counterOfPokes);
    }
}
