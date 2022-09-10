package MultidimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class N2MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int row = input[0];
        int coll = input[1];

        char[][] matrix = new char[row][coll];
        String[][] matrixStr = new String[row][coll];

        char letter = 'a';

        for (int r = 0; r < row; r++) {
            char otherLetter = letter;
            for (int c = 0; c < coll; c++) {
                matrix[r][c] = letter;
                matrixStr[r][c] = ""+letter + otherLetter + letter;
                otherLetter++;
            }
            letter++;
        }


        for (int r = 0; r < row; r++) {
            for (int c = 0; c < coll; c++) {
                System.out.print(matrixStr[r][c]+" ");
            }
            System.out.print(System.lineSeparator());
        }

    }
}
