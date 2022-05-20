package DataTypesAndVariables.lab;
import java.util.Scanner;
public class N9CenturiesToMinutes {
    public static void main(String[] arguments){
Scanner myObjectScanner = new Scanner(System.in);


        int centuries = myObjectScanner.nextInt();
        double years = centuries * 100;
        double days = years * 365.2422;
        double hours = days * 24;

        System.out.printf("%d centuries = %.0f years = %.0f days = %.0f hours = %.0f minutes %n" ,centuries,years, days,hours, hours * 60 );


    }
}
