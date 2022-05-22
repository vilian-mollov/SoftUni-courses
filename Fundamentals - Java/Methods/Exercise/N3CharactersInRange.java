package Methods.Exercise;

import java.util.Scanner;

public class N3CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String charOne = scanner.nextLine();
        String charTwo = scanner.nextLine();

        int beginning = charOne.charAt(0);
        int end = charTwo.charAt(0);
if(beginning<end) {
    printingCharactersInRange(beginning, end);

}else{
    printingCharactersInRangeBackwards(beginning, end);
}
    }

    private static void printingCharactersInRangeBackwards(int beginning, int end) {
        for (int i = end+1; i < beginning; i++) {
            System.out.print((char)i+" ");
        }
    }

    static void printingCharactersInRange(int beginning, int end) {

         for (int i = beginning+1; i < end; i++) {
             System.out.print((char)i+" ");
         }
    }
}
