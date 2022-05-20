package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class N11RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        short lostGames = Short.parseShort(scanner.nextLine());
        double priceOfHeadset = Double.parseDouble(scanner.nextLine());
        double priceOfMouse = Double.parseDouble(scanner.nextLine());
        double priceOfKeyboard = Double.parseDouble(scanner.nextLine());
        double priceOfDisplay = Double.parseDouble(scanner.nextLine());

        boolean isTwo = false;
        boolean isThree = false;
        short keyBoardTrashed = 0;
        short headSets = 0;
        short mousses = 0;
        short keyBoards = 0;
        short displays = 0;
        for (int i = 1; i <= lostGames; i++) {
            if (i % 2 == 0) {
                headSets++;
                isTwo = true;
            }
            if (i % 3 == 0) {
                mousses++;
                isThree = true;
            }
            if (isTwo && isThree) {
                keyBoardTrashed++;
                keyBoards++;
            }
            if (keyBoardTrashed % 2 == 0 && keyBoardTrashed != 0) {
                displays++;
                keyBoardTrashed = 0;
            }

            isThree = false;
            isTwo = false;
        }

        System.out.printf("Rage expenses: %.2f lv.", priceOfHeadset * headSets + priceOfMouse * mousses + priceOfKeyboard * keyBoards + priceOfDisplay * displays);


    }
}
