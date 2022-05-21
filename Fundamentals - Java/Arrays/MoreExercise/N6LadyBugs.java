package Arrays.MoreExercise;
import java.util.Scanner;

public class N6LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        String inputInitialFields = scanner.nextLine();
        String[] ladybugsIndexesString = inputInitialFields.split(" ");
        int[] ladybugsIndexes = new int[ladybugsIndexesString.length];
        parseLadyBugIndexesToInt(ladybugsIndexesString, ladybugsIndexes);

        int[] theField = new int[fieldSize];
        for (int i = 0; i < ladybugsIndexes.length; i++) {
            if (ladybugsIndexes[i] >= 0 && ladybugsIndexes[i] < theField.length) {
                theField[ladybugsIndexes[i]] = 1;
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] data = input.split(" ");
            int indexOfBug = Integer.parseInt(data[0]);
            String direction = data[1];
            int flightLength = Integer.parseInt(data[2]);
            if (indexOfBug < 0 || indexOfBug >= theField.length || theField[indexOfBug] != 1) {
                input = scanner.nextLine();
                continue;
            }
            theField[indexOfBug] = 0;
            switch (direction) {
                case "right":
                    indexOfBug += flightLength;
                    while (indexOfBug < theField.length && theField[indexOfBug] == 1) {
                        indexOfBug += flightLength;
                    }
                    if (indexOfBug < fieldSize) {
                        theField[indexOfBug] = 1;
                    }
                    break;
                case "left":
                     indexOfBug -= flightLength;
                    while (indexOfBug >= 0 && theField[indexOfBug] == 1) {
                        indexOfBug -= flightLength;
                    }
                    if (indexOfBug >=0) {
                        theField[indexOfBug] = 1;
                    }

                    break;

            }

            input = scanner.nextLine();
        }


        for (int i : theField) {
            System.out.print(i + " ");
        }

    }

    private static void parseLadyBugIndexesToInt(String[] ladybugsIndexesString, int[] ladybugsIndexes) {
        for (int i = 0; i < ladybugsIndexes.length; i++) {
            ladybugsIndexes[i] = Integer.parseInt(ladybugsIndexesString[i]);
        }
    }

}
