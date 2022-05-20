package DataTypesAndVariables.Execise;
import java.math.BigDecimal;
import java.util.Scanner;
public class N11remake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int snow=0;
        int time=0;
        int quality =0;
        BigDecimal snowballValue = new BigDecimal(0);

        for (int i = 0; i < n; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            BigDecimal x = new BigDecimal(Math.pow((snowballSnow/snowballTime),snowballQuality));

                    if(snowballValue.compareTo(x)<1){
                        snowballValue=x;
                        snow = snowballSnow;
                        time = snowballTime;
                        quality=snowballQuality;
                    }

        }
        System.out.printf("%d : %d = %.0f (%d)",snow,time,snowballValue,quality);


    }
}
