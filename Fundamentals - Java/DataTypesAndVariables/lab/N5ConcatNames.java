package DataTypesAndVariables.lab;
import java.util.Scanner;
public class N5ConcatNames {
    public static void main(String[] arguments){
        Scanner myObject= new Scanner(System.in);
        String nameOne= myObject.nextLine();
        String nameTwo = myObject.nextLine();
        String delimiter = myObject.nextLine();

        System.out.println(nameOne + delimiter + nameTwo);


    }
}
