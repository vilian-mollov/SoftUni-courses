package DataTypesAndVariables.lab;
import java.util.Scanner;

public class N6and7CharsToString {
    public static void main(String[] arguments) {
        Scanner myObject = new Scanner(System.in);

        char charOne = myObject.next().charAt(0);
        char charTwo  = myObject.next().charAt(0);
        char charThree = myObject.next().charAt(0);

        System.out.println(""+charThree + " " + charTwo +" "+ charOne);

    }



}
