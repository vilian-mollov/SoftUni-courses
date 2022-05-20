package DataTypesAndVariables.Execise;

import java.util.Scanner;

public class N11Snowballs {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double snowballValue = 0.0;
        short snowballSnow = 0;
        short snowballTime = 0;
        double snowballQuality = 0.0;

        for (int i = 1; i <= n; i++) {
            short snowballSnowOne = Short.parseShort(scanner.nextLine());
            short snowballTimeOne = Short.parseShort(scanner.nextLine());
            double snowballQualityOne = Integer.parseInt(scanner.nextLine());
           double  snowballValueOne = Math.pow((snowballSnowOne / snowballTimeOne),snowballQualityOne);


            if(snowballValue<snowballQualityOne){
                snowballValue=snowballValueOne;
                snowballSnow = snowballSnowOne;
                 snowballTime = snowballTimeOne;
                 snowballQuality = snowballQualityOne;
            }

        }

        System.out.printf("%d : %d = %.0f (%.0f)", snowballSnow, snowballTime, snowballValue, snowballQuality);
    }
}
