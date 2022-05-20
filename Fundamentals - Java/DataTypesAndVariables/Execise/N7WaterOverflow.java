package DataTypesAndVariables.Execise;

import java.util.Scanner;

public class N7WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int collectWater = 0;


        for (int i = 1; i <= n; i++) {
            int littersOfWater = scanner.nextInt();
            if (littersOfWater+collectWater <= 255) {
                collectWater += littersOfWater;

            } else {
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(collectWater);


    }
}
