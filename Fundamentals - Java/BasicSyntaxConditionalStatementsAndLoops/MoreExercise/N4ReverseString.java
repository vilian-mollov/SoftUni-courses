package BasicSyntaxConditionalStatementsAndLoops.MoreExercise;

import java.util.Scanner;

public class N4ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String reversedString = "";
        for (int i = text.length()-1; i >=0 ; i--) {
            reversedString = reversedString.concat(text.charAt(i)+"");
        }
        System.out.println(reversedString);
    }
}
