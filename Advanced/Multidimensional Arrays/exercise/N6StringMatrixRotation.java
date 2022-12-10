package MultidimensionalArrays.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class N6StringMatrixRotation {

    private static char[][] matrix;
    private static List<String> textHolder;
    private static int col;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] commandData = scanner.nextLine().split("[()]"); // Rotate(number divisible by 90)

        String command = commandData[0]; //Rotate
        int number = Integer.parseInt(commandData[1]); // the degrees to rotate

        textHolder = new ArrayList<>(); //hold initial texts
        getTexts(scanner, textHolder); // method to get the texts from the console input

        int row = textHolder.size();
        col = getCol(textHolder);
        matrix = new char[row][col];

        fillMatrix(textHolder); // fill the matrix with texts separated to chars

        List<String> result = new ArrayList<>(); // the final result to print on the console
        if (command.equals("Rotate")) {
            double value = (number * 1.00) / 90;

            double degreeValue = value / 4;
            int degreeValueWhole = (int) value / 4;
            int remainder = (int) (degreeValue * 100) - degreeValueWhole * 100;

            switch (remainder) {
                case 25:
                    // 90
                    result = rotateMatrix(Degree.NINETY); // rotates the matrix by given degrees
                    break;
                case 50:
                    //180
                    result = rotateMatrix(Degree.ONE_EIGHTY);
                    break;
                case 75:
                    //270
                    result = rotateMatrix(Degree.TWO_SEVENTY);
                    break;
                case 0:
                    //360
                    result = rotateMatrix(Degree.THREE_SIXTY);
                    break;
            }


        }

        for (String s : result) {
            System.out.println(s); // final outcome of rotation printed on the console
        }

        //Input:
        //Rotate(90)
        //hello
        //softuni
        //exam
        //END

        //Output:
        //esh
        //xoe
        //afl
        //mtl
        // uo
        // n
        // i

        //Input:
        //Rotate(270)
        //hello
        //softuni
        //exam
        //END

        //Output:
        // i
        // n
        //ou
        //ltm
        //lfa
        //eox
        //hse


        //Input:
        //Rotate(810)
        //js
        //exam
        //END

        //Output:
        //ej
        //xs
        //a
        //m

        //Input:
        //Rotate(0)
        //js
        //exam
        //END

        //Output:
        //js
        //exam

    }

    private static List<String> rotateMatrix(Degree degree) {
        List<String> result = new ArrayList<>();
        switch (degree) {
            case NINETY:
                result = rotateNinety();
                break;
            case ONE_EIGHTY:
                result = rotateOneEighty();
                break;
            case TWO_SEVENTY:
                result = rotateTwoSeventy();
                break;
            case THREE_SIXTY:
                result = rotateThreeSixty();
                break;
        }
        return result;
    }

    private static List<String> rotateNinety() {
        List<String> result = new ArrayList<>();
        StringBuilder text = new StringBuilder();
        for (int c = 0; c < col; c++) {
            for (int r = matrix.length - 1; r >= 0; r--) {
                text.append(matrix[r][c]);
            }
            result.add(text.toString());
            text.setLength(0);
        }

        return result;
    }

    private static List<String> rotateOneEighty() {
        List<String> result = new ArrayList<>();
        StringBuilder text = new StringBuilder();
        for (int r = matrix.length - 1; r >= 0; r--) {
            for (int c = col - 1; c >= 0; c--) {
                text.append(matrix[r][c]);
            }
            result.add(text.toString());
            text.setLength(0);
        }
        return result;
    }

    private static List<String> rotateTwoSeventy() {
        List<String> result = new ArrayList<>();
        StringBuilder text = new StringBuilder();

        for (int c = col - 1; c >= 0; c--) {
            for (int r = 0; r < matrix.length; r++) {
                text.append(matrix[r][c]);
            }
            result.add(text.toString());
            text.setLength(0);
        }

        return result;
    }

    private static List<String> rotateThreeSixty() {
        return textHolder;
    }

    private static void fillMatrix(List<String> textHolder) {
        for (int r = 0; r < textHolder.size(); r++) {
            StringBuilder text = new StringBuilder(textHolder.get(r));
            addSpaces(text);
            for (int c = 0; c < col; c++) {
                matrix[r][c] = text.charAt(c);
            }
        }

    }

    private static void addSpaces(StringBuilder text) {
        int timesOfSpacesNeeded = col - text.length();
        text.append(" ".repeat(Math.max(0, timesOfSpacesNeeded)));
    }

    private static int getCol(List<String> textHolder) {
        int longestText = 0;
        for (String text : textHolder) {
            if (text.length() > longestText) {
                longestText = text.length();
            }
        }
        return longestText;
    }

    private static void getTexts(Scanner scanner, List<String> textHolder) {
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            textHolder.add(input);
            input = scanner.nextLine();
        }
    }

    enum Degree {
        NINETY(90),
        ONE_EIGHTY(180),
        TWO_SEVENTY(270),
        THREE_SIXTY(360);

        final int degree;

        Degree(int degree) {
            this.degree = degree;
        }
    }

}
