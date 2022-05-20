package BasicSyntaxConditionalStatementsAndLoops.MoreExercise;

import java.util.Scanner;

public class N5Messages {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        String text = "";

        for (int i =1;i<=count;i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if(number == 2){
        text = text.concat("a");

            }
            if(number == 22){
                text = text.concat("b");

            }
            if(number == 222){
                text = text.concat("c");

            }
            if(number == 3){
                text = text.concat("d");

            }
            if(number == 33){
                text = text.concat("e");

            }
            if(number == 333){
                text = text.concat("f");

            }
            if(number == 4){
                text = text.concat("g");

            }
            if(number == 44){
                text = text.concat("h");

            }
            if(number == 444){
                text = text.concat("i");

            }
            if(number == 5){
                text = text.concat("j");

            }
            if(number == 55){
                text = text.concat("k");

            }
            if(number == 555){
                text = text.concat("l");

            }
            if(number == 6){
                text = text.concat("m");

            }
            if(number == 66){
                text = text.concat("n");

            }
            if(number == 666){
                text = text.concat("o");

            }
            if(number == 7){
                text = text.concat("p");

            }
            if(number == 77){
                text = text.concat("q");

            }
            if(number == 777){
                text = text.concat("r");

            }
            if(number == 7777){
                text = text.concat("s");

            }
            if(number == 8){
                text = text.concat("t");

            }
            if(number == 88){
                text = text.concat("u");

            }
            if(number == 888){
                text = text.concat("v");

            }
            if(number == 9){
                text = text.concat("w");

            }
            if(number == 99){
                text = text.concat("x");

            }
            if(number == 999){
                text = text.concat("y");

            }
            if(number == 9999){
                text = text.concat("z");

            }
            if(number == 0){
                text = text.concat(" ");

            }

        }
        System.out.println(text);
    }
}
