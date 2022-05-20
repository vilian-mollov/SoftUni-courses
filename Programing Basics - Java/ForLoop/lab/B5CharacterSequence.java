package ForLoop.lab;

import java.util.Scanner;

public class B5CharacterSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String word = scanner.nextLine();
        

        for (int letter = 0; letter <= word.length()-1  ; letter++) {

            System.out.printf("%c%n", word.charAt(letter));
            
        }
        
    }
}
