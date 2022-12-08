package MultidimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class N4MaximumSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndCols = Arrays.stream((scanner.nextLine().split("\\s+"))).mapToInt(Integer::parseInt).toArray();

        int row = rowsAndCols[0];
        int col = rowsAndCols[1];

        int[][] matrix = new int[row][col];
        fillMatrix(scanner, matrix, row, col);

        int bestSum = Integer.MIN_VALUE;
        int[][] bestMatrix = new int[3][3];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {

                if (validation(row, col, r, c)) continue;

                int currentSum = 0;

                currentSum = getCurrentSum(matrix, r, c, currentSum);

                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    fillBestMatrix(matrix, bestMatrix, r, c);
                }
            }
        }

        System.out.println("Sum = " + bestSum);
        printOnConsoleBestMatrix(bestMatrix);

        //Input:
        //4 5
        //1 5 5 2 4
        //2 1 4 14 3
        //3 7 11 2 8
        //4 8 12 16 4

        //Output
        //Sum = 75
        //1 4 14
        //7 11 2
        //8 12 16
    }

    private static void printOnConsoleBestMatrix(int[][] bestMatrix) {

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print(bestMatrix[r][c] + " ");
            }
            System.out.println();
        }

    }

    private static boolean validation(int row, int col, int r, int c) {
        if (c - 1 < 0) {
            return true;
        }
        if (c + 1 >= col) {
            return true;
        }
        if (r - 1 < 0) {
            return true;
        }
        if (r + 1 >= row) {
            return true;
        }
        return false;
    }

    private static int getCurrentSum(int[][] matrix, int r, int c, int currentSum) {
        currentSum += matrix[r - 1][c - 1] + matrix[r - 1][c] + matrix[r - 1][c + 1];
        currentSum += matrix[r][c - 1] + matrix[r][c] + matrix[r][c + 1];
        currentSum += matrix[r + 1][c - 1] + matrix[r + 1][c] + matrix[r + 1][c + 1];
        return currentSum;
    }

    private static void fillBestMatrix(int[][] matrix, int[][] bestMatrix, int r, int c) {
        bestMatrix[0][0] = matrix[r - 1][c - 1];
        bestMatrix[0][1] = matrix[r - 1][c];
        bestMatrix[0][2] = matrix[r - 1][c + 1];

        bestMatrix[1][0] = matrix[r][c - 1];
        bestMatrix[1][1] = matrix[r][c];
        bestMatrix[1][2] = matrix[r][c + 1];

        bestMatrix[2][0] = matrix[r + 1][c - 1];
        bestMatrix[2][1] = matrix[r + 1][c];
        bestMatrix[2][2] = matrix[r + 1][c + 1];
    }

    private static void fillMatrix(Scanner scanner, int[][] matrix, int row, int col) {

        for (int r = 0; r < row; r++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int c = 0; c < col; c++) {
                matrix[r][c] = arr[c];
            }
        }

    }
}
