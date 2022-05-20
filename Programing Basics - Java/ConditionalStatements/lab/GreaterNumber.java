package ConditionalStatements.lab;

import java.util.Scanner;

public class GreaterNumber {
    public static void main(String[] args) {
        //Въвеждане
        //чете две цели числа
        //Програма която да изписва по голямото въведено число.

        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        if(a>b){

            System.out.println(a);
        }else{

            System.out.println(b);
        }


    }
}
