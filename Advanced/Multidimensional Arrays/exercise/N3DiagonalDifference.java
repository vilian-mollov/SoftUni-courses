package MultidimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class N3DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n]; //square

        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;

       int position =0;
       int secondaryPosition = n -1;
        for (int row = 0; row < n ; row++) {
            int[] values = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            for (int col = 0; col < n; col++) {
                matrix[row][col] = values[col];
            }
            primaryDiagonal += matrix[row][position];
            position++;
            secondaryDiagonal += matrix[row][secondaryPosition];
            secondaryPosition--;
        }

        System.out.println(Math.abs(primaryDiagonal - secondaryDiagonal));


    }
}
