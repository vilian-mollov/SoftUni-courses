package DataTypesAndVariables.lab;
import java.util.Scanner;
public class N1ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double numberInMeters = scanner.nextDouble();
        System.out.printf("%.2f",numberInMeters/1000);


    }
}
