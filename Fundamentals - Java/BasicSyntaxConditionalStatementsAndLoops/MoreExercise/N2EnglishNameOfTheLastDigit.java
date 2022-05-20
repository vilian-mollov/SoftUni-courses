package BasicSyntaxConditionalStatementsAndLoops.MoreExercise;

import java.util.Scanner;

public class N2EnglishNameOfTheLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        String collector="";

        for (int i = 0; i <= number.length()-1; i++) {
          collector= ""+number.charAt(i);
        }
        int realNumber = Integer.parseInt(collector);

        if(realNumber==0){
            System.out.println("zero");
        }
        if(realNumber == 1){
            System.out.println("one");
        }if(realNumber == 2){
            System.out.println("two");
        }if(realNumber == 3){
            System.out.println("three");
        }if(realNumber == 4){
            System.out.println("four");
        }if(realNumber == 5){
            System.out.println("five");
        }if(realNumber == 6){
            System.out.println("six");
        }if(realNumber == 7){
            System.out.println("seven");
        }if(realNumber == 8){
            System.out.println("eight");
        }if(realNumber == 9){
            System.out.println("nine");
        }

    }
}
