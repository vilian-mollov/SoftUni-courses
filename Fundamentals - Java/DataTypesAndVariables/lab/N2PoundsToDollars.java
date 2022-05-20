package DataTypesAndVariables.lab;
import java.util.Scanner;
public class N2PoundsToDollars {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double britishPound = Double.parseDouble(scanner.nextLine());

        System.out.printf("%.3f",britishPound * 1.36 );




    }
}
