package DataTypesAndVariables.Execise;

import java.util.Scanner;

public class N10Refactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pokePower = Integer.parseInt(scanner.nextLine());
        int pokePowerCurrent = pokePower;
        int distanceBetweenTargets = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int hitTargets = 0;

        while (pokePowerCurrent > distanceBetweenTargets)
        {
            pokePowerCurrent -= distanceBetweenTargets;
            hitTargets++;

            if (pokePowerCurrent == pokePower / 2 && exhaustionFactor != 0)
            {
                pokePowerCurrent = pokePowerCurrent / exhaustionFactor;
            }

        }

        System.out.println(pokePowerCurrent);
        System.out.println(hitTargets);
    }


    }

