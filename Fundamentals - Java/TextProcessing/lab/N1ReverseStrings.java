package TextProcessing.lab;

import java.util.Scanner;

public class N1ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        while(!word.equals("end")){
            StringBuilder reversed = new StringBuilder(word);
            reversed.reverse();
            System.out.println(word +" = "+reversed);


            word = scanner.nextLine();
        }

    }
}
