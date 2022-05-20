package DataTypesAndVariables.lab;
import java.util.Scanner;
public class N8LowerOrUpper {
    public static void main(String[] arguments){
        Scanner newObjectScanner = new Scanner(System.in);
        char character = newObjectScanner.next().charAt(0);

        if(character>64 && character<91){
            System.out.println("upper-case");
        }else if(character>96 && character<123){
            System.out.println("lower-case");
        }else{
            System.out.println("Not a character.Symbol?");
        }

    }
}
